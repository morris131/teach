package cn.hnist.teach.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.hnist.teach.entity.Role;
import cn.hnist.teach.entity.User;
import cn.hnist.teach.service.inter.IRoleService;
import cn.hnist.teach.service.inter.IUserService;

@Controller
@RequestMapping("admin/")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("findUsers")
	public String findUsers(Integer pageNumber, Integer pageSize, Model model){
		
		if(null == pageNumber){
			pageNumber = 1;
		}
		
		if(null == pageSize){
			pageSize = 10;
		}
		
		Page<User> page = userService.findAll(new PageRequest(pageNumber-1, pageSize));		
		//每页数据
		model.addAttribute("page", page);
		//当前页
		model.addAttribute("pageNumber", pageNumber);
		return "admin/list_user";
	}
	
	@RequestMapping("saveUser")
	public String saveUser(User user){
		userService.save(user);
		return "redirect:/admin/findUsers";
	}
	
	@RequestMapping("saveUserRole")
	public String saveUserRole(Integer id,int[] roles){
		
		User u = userService.findOne(id);
		
		List<Role> roles2 = new ArrayList<Role>(); 
		
		for (int role : roles) {
			roles2.add(roleService.findOne(role));
		}
		
		u.setRoles(roles2);
		userService.save(u);
		return "redirect:/admin/findUsers";
	}
	
	@RequestMapping("modifyPassword")
	public String modifyPassword(){
		return "admin/modify_password";
	}
	
	@RequestMapping("savePassword")
	public String savePassword(String oldPassword, String newPassword, HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		user = userService.findByUsername(user.getUsername());
		
		if(null != oldPassword && null != newPassword && oldPassword.equals(user.getPassword())){
			user.setPassword(newPassword);
		}
		userService.save(user);
		
		return "redirect:/admin/logout";
	}
	
	@RequestMapping("addUser")
	public String addUser(Model model){
		Iterable<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "admin/add_user";
	}
	
	@RequestMapping("deleteUser")
	public String deleteUser(Integer id){
		userService.delete(id);
		return "redirect:/admin/findUsers";
	}
	
	@RequestMapping("updateUserRole")
	public String updateUserRole(Integer id, Model model){
		
		User user = userService.findOne(id);
		model.addAttribute("user", user);
		
		Iterable<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		
		return "admin/update_user_role";
	}

}



