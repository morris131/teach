package cn.hnist.teach.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.hnist.teach.entity.Adv;
import cn.hnist.teach.service.inter.IAdvService;

@Controller
@RequestMapping("admin/")
public class AdvController {
	
	@Resource
	private IAdvService advService;
	
	@RequestMapping("findAdvs")
	public String findAdvs(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<Adv> page = advService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_adv";
	}
	
	@RequestMapping("saveAdv")
	public String saveAdv(Adv adv,@RequestParam MultipartFile resFile,HttpServletRequest request) throws IllegalStateException, IOException{
		
	String realPath = request.getServletContext().getRealPath("static")+File.separator+"upload"+File.separator+"adv";
	
	if(null != resFile && !"".equals(resFile.getOriginalFilename())){
		
		UUID uuid = UUID.randomUUID();

		//文件真实名字
		String fileName = resFile.getOriginalFilename();
		//保存磁盘的文件的名字
		String name = uuid.toString()+fileName.substring(fileName.lastIndexOf("."));
		
		resFile.transferTo(new File(realPath +File.separator+ name));
		
		adv.setDatetime(new Date());
		adv.setCount(0L);
		adv.setPicture(name);
		
		
	}else{
		Adv adv2 = advService.findOne(adv.getId());
		adv.setPicture(adv2.getPicture());
		adv.setCount(adv2.getCount());
		adv.setDatetime(adv2.getDatetime());
	}
	
		advService.save(adv);
		return "redirect:/admin/findAdvs";
	}
	
	@RequestMapping("addAdv")
	public String addAdv(){
		return "admin/add_adv";
	}
	
	@RequestMapping("updateAdv")
	public String updateAdv(Integer id, Model model){
		Adv adv = advService.findOne(id);
		model.addAttribute("adv",adv);
		return "admin/update_adv";
	}
	
	@RequestMapping("deleteAdv")
	public String deleteAdv(Integer id){
		advService.delete(id);
		return "redirect:/admin/findAdvs";
	}

}



