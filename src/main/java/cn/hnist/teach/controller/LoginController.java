package cn.hnist.teach.controller;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.hnist.teach.entity.LoginLog;
import cn.hnist.teach.service.inter.ILoginLogService;
import cn.hnist.teach.service.inter.IUserService;

@Controller
@RequestMapping("admin")
public class LoginController {

	public static final transient Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
	private IUserService userService; 
	
	@Resource
	private ILoginLogService loginLogService;
	
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
	public String login(String userName, String userPassword,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		logger.info("登录用户名: " + userName);
		
		if (null != userName && !"".equals(userName) && null != userPassword
				&& !"".equals(userPassword)) {
			//User user = userService.findByUsername(userName);

			try {
				UsernamePasswordToken token = new UsernamePasswordToken(
						userName, userPassword);
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);

				// 记录登录日志
				String ipAddr = request.getRemoteAddr();
				String browser = request.getHeader("user-agent");

				LoginLog loginLog = new LoginLog();
				loginLog.setName(userName);
				loginLog.setIp(ipAddr);
				loginLog.setBrowser(browser);
				loginLog.setDatetime(new Date());

				loginLogService.save(loginLog);

			} catch (AuthenticationException e) {
				redirectAttributes.addFlashAttribute("message", "用户名或密码错误");
				return "redirect:/admin/login";
			}

			return "redirect:/admin/index";
		}
		redirectAttributes.addFlashAttribute("message", "用户名或密码不能为空");
		return "redirect:/admin/login";
	}
}
