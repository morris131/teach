package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeachArrangeType;
import cn.hnist.teach.service.inter.ITeachArrangeTypeService;

@Controller
@RequestMapping("admin")
public class TeachArrangeTypeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(TeachArrangeTypeController.class);
	
	@Resource
	private ITeachArrangeTypeService teachArrangeTypeService;
	
	@RequestMapping("findTeachArrangeTypes")
	public String findTeachArrangeTypes(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<TeachArrangeType> page = teachArrangeTypeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_teach_arrange_type";
	}
	
	@RequestMapping("deleteTeachArrangeType")
	public String deleteTeachArrangeType(Integer id){
		teachArrangeTypeService.delete(id);
		return "redirect:/admin/findTeachArrangeTypes";
	}
	
	@RequestMapping("saveTeachArrangeType")
	public String saveTeachArrangeType(TeachArrangeType teachArrangeType){
		teachArrangeTypeService.save(teachArrangeType);
		return "redirect:/admin/findTeachArrangeTypes";
	}

}



