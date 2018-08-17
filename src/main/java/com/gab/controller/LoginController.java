package com.gab.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gab.pojo.Command;
import com.gab.service.CommandService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	CommandService commandService;
	@RequestMapping("/doLogin")
	@ResponseBody//以json类型返回
	public void doLogin(HttpServletRequest request,HttpServletResponse response) {
		//List<Command> list=commandService.findAllCommand();
		System.out.println("this request is:"+request);
		
		
        String nick_name="";
        String head_img="";
        String sex="";
        String coutry="";
        String city="";
        String province="";
        String code="";
        nick_name=request.getParameter("nick_name");
        head_img=request.getParameter("head_img");
        sex=request.getParameter("sex");
        coutry=request.getParameter("coutry");
        city=request.getParameter("city");
        province=request.getParameter("province");
        code=request.getParameter("code");
        
        System.out.println("the name is:"+nick_name);
        System.out.println("the 图像 is:"+head_img);
        System.out.println("the 性别 is:"+sex);
        System.out.println("the 国籍 is:"+coutry);
        System.out.println("the 城市 is:"+city);
        System.out.println("the 省份 is:"+province);
        System.out.println("the code is:"+code);

	}

}
