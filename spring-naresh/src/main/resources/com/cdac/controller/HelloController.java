package com.cdac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.protobuf.Message;

@Controller
public class HelloController {
	
	@RequestMapping("/hello.cdac")
	public String SayHello(Map map) {
		map.put("message", "Welcome to Spring MVC");
		return "hello.jsp";
	}
}
