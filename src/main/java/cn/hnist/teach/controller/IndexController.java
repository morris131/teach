package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.Adv;
import cn.hnist.teach.entity.DownloadResource;
import cn.hnist.teach.entity.Message;
import cn.hnist.teach.entity.OutstandStudent;
import cn.hnist.teach.entity.TeachNews;
import cn.hnist.teach.service.inter.IAdvService;
import cn.hnist.teach.service.inter.ICourseIntroService;
import cn.hnist.teach.service.inter.IDownloadResourceService;
import cn.hnist.teach.service.inter.IMessageService;
import cn.hnist.teach.service.inter.IOutstandStudentService;
import cn.hnist.teach.service.inter.ITeachNewsService;

@Controller
public class IndexController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Resource
	private ICourseIntroService courseIntroService;
	
	@Resource
	private IAdvService advService;
	
	@Resource
	private ITeachNewsService teachNewsService;
	
	@Resource
	private IMessageService messageService;
	
	@Resource
	private IDownloadResourceService downloadResourceService;
	
	@Resource
	private IOutstandStudentService outstandStudentService;
	
	@RequestMapping("index")
	public String index(Model model){
		
		Page<TeachNews> teachNews = teachNewsService.findAll(new PageRequest(0, 5),new Short("0"));
		model.addAttribute("teachNews", teachNews);
		
		Page<TeachNews> infos = teachNewsService.findAll(new PageRequest(0, 5),new Short("1"));
		model.addAttribute("infos", infos);
		
		Page<Message> messages = messageService.findAll(new PageRequest(0, 5));
		model.addAttribute("messages", messages);
		
		Page<DownloadResource> downloadResources = downloadResourceService.findAll(new PageRequest(0, 5));
		model.addAttribute("downloadResources", downloadResources);
		
		Iterable<OutstandStudent> outstandStudents = outstandStudentService.findAll();
		model.addAttribute("outstandStudents", outstandStudents);
		
		Page<Adv> advs = advService.findAll(new PageRequest(0, 5));
		model.addAttribute("advs", advs);
		
		return "index";
	}
	
	@RequestMapping("info")
	public String info(){
		return "info";
	}
}
