package com.cos.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		user.setRole(RoleType.USER);
		//System.out.printf("%s %s %s\n", user.getUsername(), user.getEmail(), user.getPassword());
		int result = userService.db_user_join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
	}
}
