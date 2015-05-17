package cn.hnist.teach.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.TeacherIntro;
import cn.hnist.teach.entity.TeacherIntroType;
import cn.hnist.teach.service.inter.ITeacherIntroService;
import cn.hnist.teach.service.inter.ITeacherIntroTypeService;

@Controller
public class TeacherIntroController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(TeacherIntroController.class);

	@Resource
	private ITeacherIntroService teacherIntroService;
	
	@Resource
	private ITeacherIntroTypeService teacherIntroTypeService;
	
	@RequestMapping("admin/findTeacherIntros")
	public String findTeacherIntros(Integer pageNumber, Integer pageSize,Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<TeacherIntro> page = teacherIntroService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		
		return "admin/list_teacher_intro";
	}
	
	@RequestMapping("admin/addTeacherIntro")
	public String addTeacherIntro(Model model){
		
		List<TeacherIntroType> types = (List<TeacherIntroType>) teacherIntroTypeService.findAll();
		
		model.addAttribute("types", types);
		
		//获得所有教师分类
		return "admin/add_teacher_intro";
	}
	
	@RequestMapping("admin/saveTeacherIntro")
	public String saveTeacherIntro(TeacherIntro teacherIntro){
				
		teacherIntro.setDatetime(new Date());
		teacherIntro.setCount(0L);
		logger.info(teacherIntro.toString());
		teacherIntroService.save(teacherIntro);
		return "redirect:/admin/findTeacherIntros";
	}
	
	@RequestMapping("admin/updateTeacherIntro")
	public String updateTeacherIntro(Integer id,Model model){
		TeacherIntro teacherIntro = teacherIntroService.findOne(id);
		model.addAttribute(teacherIntro);
		List<TeacherIntroType> types = (List<TeacherIntroType>) teacherIntroTypeService.findAll();
		model.addAttribute("types", types);
		return "admin/update_teacher_intro";
	}
	
	@RequestMapping("admin/deleteTeacherIntro")
	public String deleteTeacherIntro(Integer id){
		teacherIntroService.delete(id);
		return "redirect:/admin/findTeacherIntros";
	}
	
	@RequestMapping("toTeacherIntro")
	public String toTeacherIntro(Integer pageNumber,Integer pageSize,Integer typeId,Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Iterable<TeacherIntroType> types = teacherIntroTypeService.findAll();
		
		PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
		
		Page<TeacherIntro> page = null;
		
		if(null == typeId){
			page = teacherIntroService.findAll(pageRequest);
		}else{
			page = teacherIntroService.findAll(pageRequest, typeId);
		}
		
		model.addAttribute("page",page);
		model.addAttribute("types",types);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("typeId", typeId);
		
		return "teacher_intro";
	}
	
	@RequestMapping("toTeacherIntroDetail")
	public String toTeacherIntroDetail(Integer id,Model model){
		
		TeacherIntro teacherIntro = teacherIntroService.findOne(id);
		teacherIntro.setCount(teacherIntro.getCount()+1);
		
		Iterable<TeacherIntroType> types = teacherIntroTypeService.findAll();
		
		model.addAttribute("teacherIntro", teacherIntro);
		model.addAttribute("types", types);
		
		//获得上一个对象
		TeacherIntro last = teacherIntroService.getLast(id);
		model.addAttribute("last", last);
		//获得下一个对象
		TeacherIntro next = teacherIntroService.getNext(id);
		model.addAttribute("next", next);
		
		return "teacher_intro_detail";
	}
}



