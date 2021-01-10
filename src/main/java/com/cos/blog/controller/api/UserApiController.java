package com.cos.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.controller.dto.ResponseDto;
import com.cos.blog.controller.service.UserService;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService;
	

	@Autowired
	private HttpSession session;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		user.setRole(RoleType.USER);
		//System.out.printf("%s %s %s\n", user.getUsername(), user.getEmail(), user.getPassword());
		
		int result = userService.db_user_join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
	/*
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
		int nErr;
		user.setRole(RoleType.USER);
		System.out.printf("call login\n");
		User principal = userService.db_user_login(user); 
		if (principal != null) {
			session.setAttribute("principal", principal);
			nErr = 1;
		}
		else {
			nErr = 0;
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(), nErr);
	}*/	
}
