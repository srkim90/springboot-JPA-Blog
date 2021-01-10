package com.cos.blog.config.auth;

import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

public class PrincipalDetail implements UserDetails{
	private User user; // 콤퍼지션
}
