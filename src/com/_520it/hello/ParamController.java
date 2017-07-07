package com._520it.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com._520it.domain.UserInfo;
//springMVC的传参方式
@Controller
public class ParamController {
	//方式一:原生api
	@RequestMapping("/param1")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ParamController.handleRequest1()");
		//请求获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserInfo info = new UserInfo(username,password);
		System.out.println(info);
		return null;
	}
	//方式二:直接获取  同名匹配规则 要求前台参数名称与后台形参名称一致
	@RequestMapping("/param2")
	public ModelAndView handleRequest2(String username,String password) throws Exception {
		System.out.println("ParamController.handleRequest2()");
		//可直接使用
		UserInfo info = new UserInfo(username,password);
		System.out.println(info);
		return null;
	}
	//方式二:直接获取  同名匹配规则
	@RequestMapping("/param3")
	//前台传参参数名称与后台形参名称不一致  通过requestParam标签声明前台参数名
	//当不需要该参数时,使用required标签,设置为flase
	public ModelAndView handleRequest3(@RequestParam(value="name",required=false)String username,String password) throws Exception {
		System.out.println("ParamController.handleRequest3()");
		//可直接使用
		UserInfo info = new UserInfo(username,password);
		System.out.println(info);
		return null;
	}
	//方式三:模型传参  直接在方法内使用模型对象类型作为参数
	@RequestMapping("/param4")
	public ModelAndView handleRequest4(UserInfo userInfo) throws Exception {
		System.out.println("ParamController.handleRequest4()");
		//可直接使用
		System.out.println(userInfo);
		return null;
	}
	//地址栏传参
	@RequestMapping("/delete/{delId}")
	public ModelAndView delete(@PathVariable("delId")Long id) throws Exception {
		System.out.println("ParamController.handleRequest4()"+id);
		return null;
	}
}
