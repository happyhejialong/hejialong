package com.ycxy.wdgj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ycxy.wdgj.rabbitmq.RabbitMqSender;

@RestController
@RequestMapping("/test")
public class TestController {
	@Autowired
	private RabbitMqSender rabbitMqSender;
	
	@GetMapping("/send")
	public void send(){
		rabbitMqSender.sendRabbitmqDirect("test", "小李子在干嘛");
	}
}
