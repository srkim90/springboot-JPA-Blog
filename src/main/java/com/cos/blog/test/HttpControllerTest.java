package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpControllerTest {
	@GetMapping("/http/get")
	//public String getTest(@RequestParam int id) {
	public String getTest(Member m) {
		Member m1 = new Member(1, "sdsad", "1123", "email@emalil.com");
		Member m2 = new Member();
		return "GET 요청" + m.getId() + " " + m.getPassword();
	}
	@PostMapping("/http/post")
	public String postTest(@RequestBody Member m) {
	//public String postTest(@RequestBody String aaaStr) {
		return "POST 요청" + " " + m.getId() + " " + m.getPassword();
	}
	@PutMapping("/http/put")
	public String putTest() {
		return "PUT 요청";
	}
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "DELETE 요청";
	}
}
