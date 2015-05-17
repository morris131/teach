package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeacherIntroType;
import cn.hnist.teach.service.inter.ITeacherIntroTypeService;

@Controller
@RequestMapping("admin")
public class TeacherIntroTypeController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(TeacherIntroTypeController.class);
	
	@Resource
	private ITeacherIntroTypeService teacherIntroTypeService;
	
	@RequestMapping("findTeacherIntroTypes")
	public String findTeacherIntroTypes(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<TeacherIntroType> page = teacherIntroTypeService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_teacher_intro_type";
	}
	
	@RequestMapping("deleteTeacherIntroType")
	public String deleteTeacherIntroType(Integer id){
		System.out.println(id);
		teacherIntroTypeService.delete(id);
		return "redirect:/admin/findTeacherIntroTypes";
	}
	
	@RequestMapping("saveTeacherIntroType")
	public String saveTeacherIntroType(TeacherIntroType teacherIntroType){
		logger.info(teacherIntroType.toString());
		teacherIntroTypeService.save(teacherIntroType);
		return "redirect:/admin/findTeacherIntroTypes";
	}

}



