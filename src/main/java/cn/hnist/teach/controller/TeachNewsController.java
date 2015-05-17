package cn.hnist.teach.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.ResourceSrc;
import cn.hnist.teach.entity.TeachNews;
import cn.hnist.teach.service.inter.IResourceSrcService;
import cn.hnist.teach.service.inter.ITeachNewsService;

@Controller
public class TeachNewsController {
	
	@Resource
	private ITeachNewsService teachNewsService;
	
	@Resource
	private IResourceSrcService resourceSrcService;
	
	@RequestMapping("admin/findTeachNews")
	public String findTeachNews(Integer pageNumber,Integer pageSize,Model model){
		if(null == pageNumber){
			pageNumber = 1;
		}
		if(null == pageSize){
			pageSize = 10;
		}
		Page<TeachNews> page = teachNewsService.findAll(new PageRequest(pageNumber-1, pageSize));		
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);	
		return "admin/list_teach_news";
	}
	
	@RequestMapping("admin/addTeachNews")
	public String addTeachNews(Model model){
		Iterable<ResourceSrc> resourceSrcs = resourceSrcService.findAll();
		model.addAttribute("resourceSrcs", resourceSrcs);
		return "admin/add_teach_news";
	}
	
	@RequestMapping("admin/saveTeachNews")
	public String saveTeachNews(TeachNews teachNews){
		
		if(null != teachNews){
			if(teachNews.getId() == 0){
				teachNews.setDatetime(new Date());
				teachNews.setCount(0L);
			}
			else{
				TeachNews teachNews2 = teachNewsService.findOne(teachNews.getId());
				teachNews.setDatetime(teachNews2.getDatetime());
				teachNews.setCount(teachNews2.getCount());
			}
			
			teachNewsService.save(teachNews);
		}
		return "redirect:/admin/findTeachNews";
	}
	
	@RequestMapping("admin/updateTeachNews")
	public String updateTeacherIntro(Integer id,Model model){
		if(null != id){
			TeachNews teachNews = teachNewsService.findOne(id);
			Iterable<ResourceSrc> resourceSrcs = resourceSrcService.findAll();
			model.addAttribute("resourceSrcs", resourceSrcs);
			model.addAttribute("teachNews",teachNews);
			return "admin/update_teach_news";
		}
		else{
			return "redirect:/admin/findTeachNews";
		}
	}
	
	@RequestMapping("admin/deleteTeachNews")
	public String deleteTeacherIntro(Integer id){
		if(null != id){
			teachNewsService.delete(id);
		}
		return "redirect:/admin/findTeachNews";
	}
	
	@RequestMapping("toTeachNews")
	public String toTeachNews(Integer pageNumber,Integer pageSize,Short typeId,Model model){
		
		if(pageNumber == null){
			pageNumber = 1;
		}
		
		if(pageSize == null){
			pageSize  = 10;
		}
		
		Pageable pageable = new PageRequest(pageNumber-1, pageSize);
		Page<TeachNews> page = null;
		if (null == typeId) {
			page = teachNewsService.findAll(pageable);
		} else {
			page = teachNewsService.findAll(pageable, typeId);
		}	
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("typeId",typeId);
		
		return "teach_news";
	}
	
	@RequestMapping("toTeachNewsDetail")
	public String toTeachNewsDetail(Integer id,Model model){
		
		TeachNews teachNews = teachNewsService.findOne(id);
		
		teachNews.setCount(teachNews.getCount()+1);
		teachNewsService.save(teachNews);
		
		model.addAttribute("teachNews", teachNews);
		
		//获得上一个对象
		TeachNews last = teachNewsService.getLast(id);
		model.addAttribute("last", last);
		//获得下一个对象
		TeachNews next = teachNewsService.getNext(id);
		model.addAttribute("next", next);
		
		return "teach_news_detail";
		
	}
}
