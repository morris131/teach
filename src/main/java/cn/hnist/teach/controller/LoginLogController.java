package cn.hnist.teach.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.LoginLog;
import cn.hnist.teach.service.inter.ILoginLogService;

@Controller
@RequestMapping("/admin")
public class LoginLogController {
	
	@Resource
	private ILoginLogService loginLogService;
	
	@RequestMapping("findLoginLogs")
	@RequiresRoles("admin")
	public String findLoginLogs(Integer pageNumber,Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		PageRequest pageRequest = new PageRequest(pageNumber-1, pageSize);
		
		Page<LoginLog> page = loginLogService.findAll(pageRequest);
		
		model.addAttribute("page", page);
		model.addAttribute("pageNumber", pageNumber);
		
		return "admin/list_login_log";
	}
	
	@RequestMapping("deleteLoginLog")
	public String deleteLoginLog(Integer id){
		loginLogService.delete(id);
		return "redirect:/admin/findLoginLogs";
	}

}



