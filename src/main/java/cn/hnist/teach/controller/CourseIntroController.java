package cn.hnist.teach.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.CourseIntro;
import cn.hnist.teach.service.inter.ICourseIntroService;

@Controller
public class CourseIntroController {
	
	@Resource
	private ICourseIntroService courseIntroService;
	
	@RequestMapping("admin/findCourseIntros")
	public String findCourseIntros(Integer pageNumber, Integer pageSize, Model model){
		if(null == pageNumber){
			pageNumber = 1;
		}
		if(null == pageSize){
			pageSize = 10;
		}	
		Page<CourseIntro> page = courseIntroService.findAll(new PageRequest(pageNumber-1, pageSize));		
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_course_intro";
	}
	
	@RequestMapping("admin/addCourseIntro")
	public String addCourseIntro(){
		return "admin/add_course_intro";
	}
	
	@RequestMapping("admin/saveCourseIntro")
	public String saveCourseIntro(CourseIntro courseIntro){
		courseIntroService.save(courseIntro);
		return "redirect:/admin/findCourseIntros";
	}
	
	@RequestMapping("admin/updateCourseIntro")
	public String updateCourseIntro(Integer id,Model model){
		CourseIntro courseIntro = courseIntroService.findOne(id);
		model.addAttribute(courseIntro);
		return "admin/update_course_intro";
	}
	
	@RequestMapping("admin/deleteCourseIntro")
	public String deleteCourseIntro(Integer id){
		courseIntroService.delete(id);
		return "redirect:/admin/findCourseIntros";
	}
	
	@RequestMapping("toCourseIntro")
	public String toCourseIntro(Integer id,Model model){
		List<CourseIntro> courseIntros = (List<CourseIntro>) courseIntroService.findAll();	
		if(null == id){
			id = -1;
			model.addAttribute("courseIntro", courseIntros.get(0));
		}	
		for (CourseIntro courseIntro : courseIntros) {	
			if(id == courseIntro.getId()){
				model.addAttribute("courseIntro", courseIntro);
			}
		}
		model.addAttribute("courseIntros", courseIntros);
		return "course_intro";
	}

}



