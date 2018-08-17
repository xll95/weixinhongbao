package com.gab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gab.mapper.CommandMapper;
import com.gab.pojo.Command;
import com.gab.service.CommandService;

@Service("commandService")
public class CommandServiceImpl  implements CommandService{

	@Autowired
	public CommandMapper commandMapper;
	@Override
	public List<Command> findAllCommand() {
		// TODO Auto-generated method stub
		return commandMapper.findAllCommand();
	}

}
