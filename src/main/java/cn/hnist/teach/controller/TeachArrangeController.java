package cn.hnist.teach.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeachArrange;
import cn.hnist.teach.entity.TeachArrangeType;
import cn.hnist.teach.service.inter.ITeachArrangeService;
import cn.hnist.teach.service.inter.ITeachArrangeTypeService;

@Controller
public class TeachArrangeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(TeachArrangeController.class);

	@Resource
	private ITeachArrangeService teachArrangeService;
	
	@Resource
	private ITeachArrangeTypeService teachArrangeTypeService;
	
	@RequestMapping("admin/findTeachArranges")
	public String findTeachArranges(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<TeachArrange> page = teachArrangeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_teach_arrange";
	}
	
	@RequestMapping("admin/addTeachArrange")
	public String addTeachArrange(Model model){
		
		List<TeachArrangeType> types = (List<TeachArrangeType>) teachArrangeTypeService.findAll();
		
		model.addAttribute("types", types);
		
		//获得所有教师分类
		return "admin/add_teach_arrange";
	}
	
	@RequestMapping("admin/saveTeachArrange")
	public String saveTeachArrange(TeachArrange teachArrange){
				
		teachArrange.setDatetime(new Date());
		teachArrange.setCount(0L);
		logger.info(teachArrange.toString());
		teachArrangeService.save(teachArrange);
		return "redirect:/admin/findTeachArranges";
	}
	
	@RequestMapping("admin/updateTeachArrange")
	public String updateTeachArrange(Integer id,Model model){
		TeachArrange teachArrange = teachArrangeService.findOne(id);
		model.addAttribute(teachArrange);
		List<TeachArrangeType> types = (List<TeachArrangeType>) teachArrangeTypeService.findAll();
		model.addAttribute("types", types);
		return "admin/update_teach_arrange";
	}
	
	@RequestMapping("admin/deleteTeachArrange")
	public String deleteTeachArrange(Integer id){
		teachArrangeService.delete(id);
		return "redirect:/admin/findTeachArranges";
	}
	
	/////////////////////////////////////////////
	@RequestMapping("toTeachArrange")
	public String toTeachArrange(Integer pageNumber,Integer pageSize,Integer typeId,Model model){
		
		if (pageNumber == null) {
			pageNumber = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}

		Pageable pageable = new PageRequest(pageNumber-1, pageSize);

		Page<TeachArrange> page = null;

		if (typeId == null) {
			page = teachArrangeService.findAll(pageable);
		} else {
			page = teachArrangeService.findAll(pageable, typeId);
		}

		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("typeId",typeId);
		
		//获得所有的类型
		Iterable<TeachArrangeType> types = teachArrangeTypeService.findAll();
		model.addAttribute("types", types);
		
		return "teach_arrange";
	}
	
	@RequestMapping("toTeachArrangeDetail")
	public String toTeachArrangeDetail(Integer id,Model model){
		
		if(id != null){
			TeachArrange teachArrange = teachArrangeService.findOne(id);
			teachArrange.setCount(teachArrange.getCount()+1);
			model.addAttribute("teachArrange", teachArrange);
			
			//获得所有的类型
			Iterable<TeachArrangeType> types = teachArrangeTypeService.findAll();
			model.addAttribute("types", types);
			
			//获得上一个对象
			TeachArrange last = teachArrangeService.getLast(id);
			model.addAttribute("last", last);
			//获得下一个对象
			TeachArrange next = teachArrangeService.getNext(id);
			model.addAttribute("next", next);
		}
		
		return "teach_arrange_detail";
	}
}



