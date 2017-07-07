package com._520it.hello;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

//SpringMVC文件上传/下载练习
@Controller
public class FileUploadController {
    //上传
    @RequestMapping("/upload")
    public  void  fileUpload(MultipartFile file) throws Exception {
        System.out.println(file.getName());//接收的形参名称
        System.out.println(file.getContentType());//文件类型
        System.out.println(file.getOriginalFilename());//文件名称
        System.out.println(file.getSize());//文件大小
        System.out.println(file.getInputStream());//输入流
        //将文件写出到指定位置
        FileOutputStream os = new FileOutputStream("E:/a.png");
        IOUtils.copy(file.getInputStream(), os);
        os.close();
    }
    //下载
    @RequestMapping("/download")
    public void fileDownload(HttpServletResponse response){
        FileInputStream inputStream =null;
        try {
            //读取需要下载的文件
            inputStream =new FileInputStream("E:/a.png");
            //设置响应头,文件可下载
            //解决中文文件名不显示问题
            String fileName=new String("小黄人".getBytes(),"iso-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+fileName+".jpg");
            //通过响应流将文件响应出去
            IOUtils.copy(inputStream,response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
