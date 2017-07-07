package com._520it.hello;

import com._520it.domain.Employee;
import com._520it.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.Bidi;
import java.util.Date;

//ModelAttribute标签的使用
@Controller
public class ModelAttributeController {
    //用法一:修改返回值的默认key
    @RequestMapping("/modelAttributeTest1")
    @ModelAttribute("u")
    public UserInfo handle(){
        return new UserInfo("wade","123");//默认key值为userInfo
    }

    //用法二:贴在控制器方法形参上,表示将参数放在模型上(作用域中)
    @RequestMapping("/modelAttributeTest2")
    public void handle2(@ModelAttribute("u2") UserInfo userInfo){//前台通过u2访问
        userInfo.setInputTime(new Date());
    }

    //用法三:配合initBinder使用,完成类似struts2中的参数对象导航
    @RequestMapping("/modelAttributeTest3")
    public void handle3(@ModelAttribute("info")UserInfo info,@ModelAttribute("emp")Employee emp){
        System.out.println("info.username====>"+info.getUsername());
        System.out.println("emp.username=====>"+emp.getUsername());
    }
    @InitBinder("info")
    public void initBinder1(WebDataBinder binder){
        binder.setFieldDefaultPrefix("info.");
    }
    @InitBinder("emp")
    public void initBinder2(WebDataBinder binder){
        binder.setFieldDefaultPrefix("emp.");
    }

    //用法四:实现类似struts中的预处理
    @RequestMapping("/modelAttributeTest4")
    public void handle4(@ModelAttribute("u3")UserInfo userInfo){
        System.out.println(userInfo.getUsername());
    }
    @ModelAttribute
    public void prehandle(Model model){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wade");
        model.addAttribute("u3",userInfo);
    }

}
