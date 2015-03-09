/**
 *	Copyright (C) 2015 www.hinst.cn All rights reserved. 
 */
package cn.hnist.teach.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.CourseIntro;
import cn.hnist.teach.service.inter.ICourseIntroService;

@Controller
public class IndexController {
	
	@Resource
	private ICourseIntroService<CourseIntro,Integer> courseIntroService;

	@RequestMapping("index")
	public String index(){
		
		List<CourseIntro> findAll = courseIntroService.findAll();
		
		for (CourseIntro courseIntro : findAll) {
			System.out.println(courseIntro);
		}
		
		return "index";
	}
	
	@RequestMapping("info")
	public String info(){
		return "info";
	}
}
