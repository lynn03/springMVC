package com._520it.hello;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com._520it.domain.UserInfo;

//springMVC的传值方式
@Controller
public class ValueController {
	//方式一:原生api
	@RequestMapping("/value1")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ParamController.handleRequest1()");
		request.setAttribute("msg", "午餐吃的香辣鸡丁!");
		//请求转发到jsp页面
		request.getRequestDispatcher("forward:/msg").forward(request, response);
		return null;
	}
	//方式二:使用默认的ModelAndView对象
	@RequestMapping("/value2")
	public ModelAndView handleRequest2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ParamController.handleRequest2()");
		ModelAndView mv =new ModelAndView();
		//******addObject方法********
		mv.addObject("msg","今天天气不错");
		//********addAllObject方法******
		Map<String, Object> modelMap = new HashMap<>();
		modelMap.put("username", "lynn");//页面通过key取值即可
		modelMap.put("age", "22");
		mv.addAllObjects(modelMap);
		//********addObject方法一个参数***
		mv.addObject("明天天气不错!!!");//此时没有key值,页面取值通过类型全小写string
		mv.addObject(new UserInfo("wade","123456"));//userInfo
		mv.addObject(new UserInfo("lynn","456789"));//覆盖之前的userInfo
		mv.setViewName("forward:/msg.jsp");
		return mv;
	}
	//直接返回模型对象信息,没有返回视图
	@RequestMapping("/value3")
	//@ModelAttribute("u")//修改返回对象默认的key为u
	public UserInfo handleRequest3(){
		return new UserInfo("admin","123");
		//当没有返回视图时,默认去找请求的value3.jsp
		//配置视图解析器之后,根据前缀和后缀去找对应的资源 /WEB-INF/views/value3.jsp
	}

	//返回的是String时,视图为字符串,
	@RequestMapping("/value4")
	public String handle(Model mv){
		mv.addAttribute("msg","这是一条信息~");
		return "xixi";
	}

}
