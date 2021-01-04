package com.cos.blog.controller.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional 
	public int db_user_join(User user) {
		try {
			userRepository.save(user);
			return 1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
