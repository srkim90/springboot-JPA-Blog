package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	@GetMapping("/tmp/home")
	public String tmpHome() {
		return "/home.html";
	}
	
	@GetMapping("/tmp/img")
	public String tmpImg() {
		return "/image.png";
	}
	
	@GetMapping("/tmp/jsp")
	public String tmpJsp() {
		return "/test";
	}
	
}
