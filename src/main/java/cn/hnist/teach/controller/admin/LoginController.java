package cn.hnist.teach.controller.admin;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.hnist.teach.entity.TeachUser;
import cn.hnist.teach.service.inter.ITeachUserService;
import cn.hnist.teach.util.MD5;

@Controller
@RequestMapping("admin")
public class LoginController {

	public static final transient Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private ITeachUserService<TeachUser,String> teachUserService; 
	
	@RequestMapping("index")
	public String index() {
		return "admin/index";
	}
	
	@RequestMapping("logout")
	public String logout() {
		logger.info("退出登录");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:admin/login";
	}
	
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String userPassword) {
		userPassword = MD5.GetMD5Code(userPassword);
		logger.info("登录用户名: " + userName);
		TeachUser user = teachUserService.findOne(userName);
		
		logger.info(user.toString());
		
		try {
			// 如果登陆成功
			if (user.getUserName().equals(userName) && user.getUserPassword().equals(userPassword)) {
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUserPassword());
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/index";
	}
}
