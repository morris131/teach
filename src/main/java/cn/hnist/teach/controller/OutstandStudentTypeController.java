/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.OutstandStudentType;
import cn.hnist.teach.service.inter.IOutstandStudentTypeService;

@Controller
@RequestMapping("admin")
public class OutstandStudentTypeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(OutstandStudentTypeController.class);
	
	@Resource
	private IOutstandStudentTypeService outstandStudentTypeService;
	
	@RequestMapping("findOutstandStudentTypes")
	public String findOutstandStudentTypes(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<OutstandStudentType> page = outstandStudentTypeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_outstand_student_type";
	}
	
	@RequestMapping("deleteOutstandStudentType")
	public String deleteOutstandStudentType(Short id){
		outstandStudentTypeService.delete(id);
		return "redirect:/admin/findOutstandStudentTypes";
	}
	
	@RequestMapping("saveOutstandStudentType")
	public String saveOutstandStudentType(OutstandStudentType OutstandStudentType){
		outstandStudentTypeService.save(OutstandStudentType);
		return "redirect:/admin/findOutstandStudentTypes";
	}

}



