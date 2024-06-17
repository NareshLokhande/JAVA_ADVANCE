package com.myapp.mywebdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
	
	@GetMapping("/home-page")
	public String open() {
		return "home";
	}
}
