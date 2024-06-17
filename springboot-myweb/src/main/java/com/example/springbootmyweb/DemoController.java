package com.example.springbootmyweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/home-page")
	public String openHome() {
		return "home.jsp";
	}
}
