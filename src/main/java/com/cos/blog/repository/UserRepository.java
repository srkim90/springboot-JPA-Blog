package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;
//@Repository 없이도 자동으로 인젝션이 된단다.
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	// JPA Naming 쿼리
	// SELECT * FROM user WHERE username = ?1 AND password = ?2;
	//User findByUsernameAndPassword(String username, String password);
	
	//@Query(value="SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
	//User login(String username, String Password);
}
