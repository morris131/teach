/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeacherIntro;
import cn.hnist.teach.service.inter.ITeacherIntroService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	TeacherIntroController.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月9日 下午8:32:52
 */
@Controller
@RequestMapping("admin")
public class TeacherIntroController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(TeacherIntroController.class);

	@Resource
	private ITeacherIntroService<TeacherIntro, Integer> teacherIntroService;
	
	@RequestMapping("findTeacherIntros")
	public String findTeacherIntros(Model model){
		List<TeacherIntro> teacherIntros = teacherIntroService.findAll();	
		model.addAttribute("teacherIntros",teacherIntros);
		return "admin/teacher_intro";
	}
	
	@RequestMapping("addTeacherIntro")
	public String addTeacherIntro(){
		return "admin/add_teacher_intro";
	}
	
	@RequestMapping("saveTeacherIntro")
	public String saveTeacherIntro(TeacherIntro teacherIntro){
		logger.info(teacherIntro.toString());
		teacherIntroService.save(teacherIntro);
		return "redirect:/admin/findTeacherIntros";
	}
	
	@RequestMapping("updateTeacherIntro")
	public String updateTeacherIntro(Integer teacherId,Model model){
		TeacherIntro teacherIntro = teacherIntroService.findOne(teacherId);
		model.addAttribute(teacherIntro);
		return "admin/update_teacher_intro";
	}
	
	@RequestMapping("deleteTeacherIntro")
	public String deleteTeacherIntro(Integer teacherId){
		teacherIntroService.delete(teacherId);
		return "redirect:/admin/findTeacherIntros";
	}
}



