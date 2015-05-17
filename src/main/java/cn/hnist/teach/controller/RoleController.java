package cn.hnist.teach.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.Role;
import cn.hnist.teach.service.inter.IRoleService;

@Controller
@RequestMapping("admin/system")
public class RoleController {
	
	public static final transient Logger logger = LoggerFactory.getLogger(RoleController.class);
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("findRoles")
	//@RequiresRoles("admin")
	public String findRoles(Model model){
		
		List<Role> roles = (List<Role>) roleService.findAll();
		
		model.addAttribute("roles",roles);
		
		return "admin/system/list_role";
	}
	
	

}



