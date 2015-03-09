/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeacherIntroType;
import cn.hnist.teach.service.inter.ITeacherIntroTypeService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeacherIntroTypeController.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午9:04:54
 */
@Controller
@RequestMapping("admin")
public class TeacherIntroTypeController {
	
	@Resource
	private ITeacherIntroTypeService<TeacherIntroType, Integer> teacherIntroTypeService;
	
	@RequestMapping("findTeacherIntroTypes")
	public String findTeacherIntroTypes(Model model){
		List<TeacherIntroType> teacherIntroTypes = teacherIntroTypeService.findAll();	
		model.addAttribute("teacherIntroTypes",teacherIntroTypes);
		return "admin/teacher_intro_type";
	}
	
	

}



