package com.cos.blog.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@Transactional 
	public int db_user_join(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encode.encode(rawPassword);
		user.setPassword(encPassword);
		try {
			userRepository.save(user);
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	/*@Transactional(readOnly = true) //Select 할 때 트렌젝션 시작, 서비스 종료시에 트랜잭션 종료 (정합성)
	public User db_user_login(User user) {
		User db_user = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		return db_user;
	}*/
}
