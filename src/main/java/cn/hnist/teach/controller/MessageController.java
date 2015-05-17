package cn.hnist.teach.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.Message;
import cn.hnist.teach.service.inter.IMessageService;

@Controller
public class MessageController {
	
	@Resource
	private IMessageService messageService;
	
	@RequestMapping("admin/findMessages")
	public String findMessages(Integer pageNumber,Integer pageSize,Short isValid,Model model){
		if(pageNumber == null){
			pageNumber = 1;
		}
		if(pageSize == null){
			pageSize = 10;
		}
		Pageable pageable = new PageRequest(pageNumber-1, pageSize);
		Page<Message> page = null;
		if(isValid == null){
			page = messageService.findAll(pageable);
		}else{
			page = messageService.findAll(pageable,isValid);
		}
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_message";
	}
	
	@RequestMapping("admin/addMessage")
	public String addMessage(){
		return "admin/add_message";
	}
	
	@RequestMapping("admin/saveMessage")
	public String saveMessage(Message message){
		Message message2 = messageService.findOne(message.getId());
		message2.setReply(message.getReply());
		message2.setIsValid(message.getIsValid());
		messageService.save(message2);
		return "redirect:/admin/findMessages";
	}
	
	@RequestMapping("admin/updateMessage")
	public String updatemessage(Integer id,Model model){
		Message message = messageService.findOne(id);
		model.addAttribute(message);
		return "admin/update_message";
	}
	
	@RequestMapping("admin/deleteMessage")
	public String deleteMessage(Integer id){
		messageService.delete(id);
		return "redirect:/admin/findMessages";
	}
	
	@RequestMapping("toMessage")
	public String toListMessage(Integer pageNumber,Integer pageSize,Model model){
		if(pageNumber == null){
			pageNumber = 1;
		}
		if(pageSize == null){
			pageSize = 10;
		}
		Pageable pageable = new PageRequest(pageNumber-1, pageSize);
		Page<Message> messages = null;
		messages = messageService.findAll(pageable,Short.parseShort("1"));
		model.addAttribute("messages", messages);
		model.addAttribute("pageNumber", pageNumber);
		return "message";
	}
	
	@RequestMapping("toPublishMessage")
	public String toPublishMessage(){
		return "publish_message";
	}
	
	@RequestMapping("publishMessage")
	public String publishMessage(Message message){	
		message.setDatetime(new Date());
		messageService.save(message);
		return "redirect:toMessage";
	}

}
