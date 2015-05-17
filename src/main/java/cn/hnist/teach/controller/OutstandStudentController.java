package cn.hnist.teach.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.hnist.teach.entity.OutstandStudent;
import cn.hnist.teach.entity.OutstandStudentType;
import cn.hnist.teach.entity.ResourceSrc;
import cn.hnist.teach.service.inter.IOutstandStudentService;
import cn.hnist.teach.service.inter.IOutstandStudentTypeService;
import cn.hnist.teach.service.inter.IResourceSrcService;

@Controller
public class OutstandStudentController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(OutstandStudentController.class);

	@Resource
	private IOutstandStudentService outstandStudentService;
	
	@Resource
	private IResourceSrcService resourceSrcService;
	
	@Resource
	private IOutstandStudentTypeService outstandStudentTypeService;
	
	@RequestMapping("admin/findOutstandStudents")
	public String findOutstandStudents(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<OutstandStudent> page = outstandStudentService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_outstand_student";
	}
	
	@RequestMapping("admin/addOutstandStudent")
	public String addOutstandStudent(Model model){
		
		List<OutstandStudentType> types = (List<OutstandStudentType>) outstandStudentTypeService.findAll();	
		model.addAttribute("types", types);
		
		Iterable<ResourceSrc> resourceSrcs = resourceSrcService.findAll();
		model.addAttribute("resourceSrcs", resourceSrcs);
		
		return "admin/add_outstand_student";
	}
	
	@RequestMapping("admin/saveOutstandStudent")
	public String saveOutstandStudent(OutstandStudent outstandStudent,@RequestParam MultipartFile resFile,HttpServletRequest request) throws IllegalStateException, IOException{
			
		String realPath = request.getServletContext().getRealPath("static")+File.separator+"upload"+File.separator+"photo";
		
		if(null != resFile && !"".equals(resFile.getOriginalFilename())){
			
			UUID uuid = UUID.randomUUID();

			//文件真实名字
			String fileName = resFile.getOriginalFilename();
			//保存磁盘的文件的名字
			String name = uuid.toString()+fileName.substring(fileName.lastIndexOf("."));
			
			resFile.transferTo(new File(realPath +File.separator+ name));
			
			outstandStudent.setDatetime(new Date());
			outstandStudent.setCount(0L);
			outstandStudent.setFileName(name);
			
			
		}else{
			OutstandStudent outstandStudent2 = outstandStudentService.findOne(outstandStudent.getId());
			outstandStudent.setFileName(outstandStudent2.getFileName());
			outstandStudent.setCount(outstandStudent2.getCount());
			outstandStudent.setDatetime(outstandStudent2.getDatetime());
		}
		
		outstandStudentService.save(outstandStudent);
		return "redirect:/admin/findOutstandStudents";
	}
	
	@RequestMapping("admin/updateOutstandStudent")
	public String updateOutstandStudent(Integer id,Model model){
		OutstandStudent outstandStudent = outstandStudentService.findOne(id);
		model.addAttribute(outstandStudent);
		List<OutstandStudentType> types = (List<OutstandStudentType>) outstandStudentTypeService.findAll();
		model.addAttribute("types", types);
		
		Iterable<ResourceSrc> resourceSrcs = resourceSrcService.findAll();
		model.addAttribute("resourceSrcs", resourceSrcs);
		return "admin/update_outstand_student";
	}
	
	@RequestMapping("admin/deleteOutstandStudent")
	public String deleteTeachArrangOutstandStudente(Integer id,HttpServletRequest request){
		OutstandStudent outstandStudent = outstandStudentService.findOne(id);
		String fileName = outstandStudent.getFileName();
		String realPath = request.getServletContext().getRealPath("static")+File.separator+"upload"+File.separator+"photo";
		File file = new File(realPath, fileName);
		if(file.exists()){
			file.delete();
		}
		outstandStudentService.delete(id);
		return "redirect:/admin/findOutstandStudents";
	}
	
	/////////////////////////////////////////////
	@RequestMapping("toOutstandStudent")
	public String toOutstandStudent(Integer pageNumber,Integer pageSize,Short typeId,Model model){
		
		if (pageNumber == null) {
			pageNumber = 1;
		}

		if (pageSize == null) {
			pageSize = 10;
		}

		Pageable pageable = new PageRequest(pageNumber-1, pageSize);

		Page<OutstandStudent> page = null;

		if (typeId == null) {
			page = outstandStudentService.findAll(pageable);
		} else {
			page = outstandStudentService.findAll(pageable, typeId);
		}

		model.addAttribute("page", page);
		
		//获得所有的类型
		Iterable<OutstandStudentType> types = outstandStudentTypeService.findAll();
		model.addAttribute("types", types);
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("typeId", typeId);
		
		return "outstand_student";
	}

	@RequestMapping("toOutstandStudentDetail")
	public String toOutstandStudentDetail(Integer id,Model model){
		
		if(id != null){
			OutstandStudent outstandStudent = outstandStudentService.findOne(id);
			model.addAttribute("outstandStudent", outstandStudent);
			
			outstandStudent.setCount(outstandStudent.getCount()+1);
			outstandStudentService.save(outstandStudent);
			
			//获得所有的类型
			Iterable<OutstandStudentType> types = outstandStudentTypeService.findAll();
			model.addAttribute("types", types);
			
			//获得上一个对象
			OutstandStudent last = outstandStudentService.getLast(id);
			model.addAttribute("last", last);
			//获得下一个对象
			OutstandStudent next = outstandStudentService.getNext(id);
			model.addAttribute("next", next);
		}
		
		return "outstand_student_detail";
	}
}



