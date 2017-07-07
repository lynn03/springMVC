package com._520it.hello;

import com._520it.domain.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//返回JSON数据
@Controller
public class JSONController {
    @RequestMapping("/json")
    @ResponseBody//贴上该标签后,将返回的数据通过ObjectMapper转换为json数据响应
    //SpringMVC不再返回视图
    public UserInfo getJson(){
        return new UserInfo("wade","123456");
    }
}
/**导入json支持jar包
 * 在需要返回json数据的方法上贴ResponseBody标签
 *
 */
