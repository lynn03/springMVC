package com._520it.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller//告诉springmvc,使用注解配置url信息
@RequestMapping("/test")//配置后该控制器下所有方法的访问必须加上该注解内容
public class AnnoController {
	@RequestMapping("/anno")//前端访问对应的方法
	public ModelAndView anno(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("AnnoController.anno()");
		return null;
	}
	@RequestMapping("/anno2")//前端访问对应的方法
	public ModelAndView anno2(HttpServletRequest request, HttpSession session) throws Exception {
		System.out.println("AnnoController.anno2()"+session);
		return null;
	}

	@RequestMapping("/anno3")//前端访问对应的方法
	public ModelAndView anno3(String username) throws Exception {
		System.out.println("AnnoController.anno2()"+username);
		return null;
	}
}
