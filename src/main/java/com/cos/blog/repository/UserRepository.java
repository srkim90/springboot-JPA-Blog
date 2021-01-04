package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cos.blog.model.User;
//@Repository 없이도 자동으로 인젝션이 된단다.
//@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
