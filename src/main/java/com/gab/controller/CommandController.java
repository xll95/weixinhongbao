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
@RequestMapping("/command")
public class CommandController {
	
	@Autowired
	CommandService commandService;
	@RequestMapping("/findAll")
	@ResponseBody//以json类型返回
	public List findAll(HttpServletRequest request,HttpServletResponse response) {
		List<Command> list=commandService.findAllCommand();
		//System.out.println(list);
		return list;
	}

}
