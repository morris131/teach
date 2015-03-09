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

import cn.hnist.teach.entity.CourseIntro;
import cn.hnist.teach.service.inter.ICourseIntroService;

/** 
 *	项 目 名:	teach
 *  文 件 名:	CourseIntroController.java
 *	文件描述:	......
 *	作    者:	Morris
 *	创建时间:	2015年3月8日 上午11:41:45
 */
@Controller
@RequestMapping("admin")
public class CourseIntroController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(CourseIntroController.class);
	
	@Resource
	private ICourseIntroService<CourseIntro, Integer> courseIntroService;
	
	@RequestMapping("findCourseIntros")
	public String findCourseIntros(Model model){
		List<CourseIntro> courseIntros = courseIntroService.findAll();	
		model.addAttribute("courseIntros",courseIntros);
		return "admin/course_intro";
	}
	
	@RequestMapping("addCourseIntro")
	public String addCourseIntro(){
		return "admin/add_course_intro";
	}
	
	@RequestMapping("saveCourseIntro")
	public String saveCourseIntro(CourseIntro courseIntro){
		logger.info(courseIntro.toString());
		courseIntroService.save(courseIntro);
		return "redirect:/admin/findCourseIntros";
	}
	
	@RequestMapping("updateCourseIntro")
	public String updateCourseIntro(Integer courseId,Model model){
		CourseIntro courseIntro = courseIntroService.findOne(courseId);
		model.addAttribute(courseIntro);
		return "admin/update_course_intro";
	}
	
	@RequestMapping("deleteCourseIntro")
	public String deleteCourseIntro(Integer courseId){
		courseIntroService.delete(courseId);
		return "redirect:/admin/findCourseIntros";
	}

}



