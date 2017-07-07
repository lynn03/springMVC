package com._520it.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
//第一个springMVC程序     实现Controller接口
public class HelloController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("HelloController.handleRequest()");
		ModelAndView md =new ModelAndView();
		md.setViewName("/msg.jsp");
		md.addObject("msg","今天天气不错...");
		//可直接返回模型和视图
		return md;
	}
}
