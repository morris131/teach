package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.DownloadResourceType;
import cn.hnist.teach.service.inter.IDownloadResourceTypeService;

@Controller
@RequestMapping("admin")
public class DownloadResourceTypeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(DownloadResourceTypeController.class);
	
	@Resource
	private IDownloadResourceTypeService downloadResourceTypeService;
	
	@RequestMapping("findDownloadResourceTypes")
	public String findDownloadResourceTypes(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<DownloadResourceType> page = downloadResourceTypeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_download_resource_type";
	}
	
	@RequestMapping("deleteDownloadResourceType")
	public String deleteDownloadResourceType(Short id){
		downloadResourceTypeService.delete(id);
		return "redirect:/admin/findDownloadResourceTypes";
	}
	
	@RequestMapping("saveDownloadResourceType")
	public String saveDownloadResourceType(DownloadResourceType downloadResourceType){
		downloadResourceTypeService.save(downloadResourceType);
		return "redirect:/admin/findDownloadResourceTypes";
	}

}



