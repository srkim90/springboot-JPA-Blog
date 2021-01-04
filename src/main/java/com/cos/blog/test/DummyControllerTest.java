package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.persistence.EnumType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/dummy/join")
	//public String join(String username, String password, String email)
	public String join(User user)
	{
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "OK username:" + user.getUsername() + " password:" + user.getPassword() + " email:" + user.getEmail();
	}

	@GetMapping("/dummy/user/page")
	public Page<User> pageList(@PageableDefault(size=2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> users = userRepository.findAll(pageable); 
		return users;
		
	}
	
	@Transactional // 함수종료시 자동 커밋 되여
	@PutMapping("/dummy/user/{id}")
	//public User detail(@PathVariable int id, User requestUser) {
	//userRepository.save ==> id 없으면 insert, 있으면 업데이트를 한돠
	public User update(@PathVariable int id, @RequestBody User requestUser) {
		System.out.printf("id : %d\n", id);
		System.out.printf("pw : %s\n", requestUser.getPassword());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Not exist user");
		});
		
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		
		//userRepository.save(user);
		return user;
	}

	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id){
		try {
			userRepository.deleteById(id);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			return "Not exist ID";	
		}
		return "delete is completed";
		
	}
	
	@GetMapping("/dummy/user")
	public List<User> list(){
		return userRepository.findAll();
		
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//User user = userRepository.findById(id).get();
		/*
		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
			@Override
			public User get() {
				// TODO Auto-generated method stub
				return new User();
			}
		});
		*/
		/*
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return null; //IllegalArgumentException("Not exist user");
			}
			
		
		}); libonzu
		*/
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("Not exist user");
		});
		
		return user ;
	}
	

	
}
