package com._520it.hello;

import com._520it.domain.UserInfo;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

//日期类型返回json数据
@Controller
public class DateJsonController {
    //后台往前台
    @RequestMapping("/date")
    @ResponseBody
    public UserInfo getJson(){
        return new UserInfo("lynn","1234",new Date());
    }
    //前台往后台
    @RequestMapping("/dateinput")
    @ResponseBody
    public UserInfo getdJson(UserInfo info){
        System.out.println(info);
        return null;
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("initBinder");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
/**
 * 后台往前台
 * 返回json数据带有日期类型时,默认返回毫秒数
 * 解决方案:
 *      1:在需要转换的日期字段上贴上JsonFormat标签
 *      2:在配置文件中配置
 *
 *
 * 前台往后台:
 *      1:在日期字段上贴上DateTimeFormat标签
 *      2:在Controller中添加一个initBinder方法
 *
 */


