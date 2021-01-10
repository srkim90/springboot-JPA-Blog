package com.cos.blog.config;

import javax.annotation.security.PermitAll;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//빈 등록 합시다 ㅈㅈ

@Configuration
@EnableWebSecurity // 시큐리티 필터 추가 == 시큐리티 활성화 된 상태에서 설정을 여기서 하겟슴돠
@EnableGlobalMethodSecurity(prePostEnabled = true) // 툭정 주소로 접근을 하면 권한 및 인증을 미리 체크 하겠다는 뜻 상기 3개는 셋트 걍 쓰면 됨
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Bean //IoC 가 되여!
	public BCryptPasswordEncoder encodePWD() { 
		String encPassword = new BCryptPasswordEncoder().encode("12343");
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.csrf().disable()
			.authorizeRequests()
			  .antMatchers("/", "/auth/**", "/js/*", "/css/**", "/image/**")
			  .permitAll()
			  .anyRequest()
			  .authenticated()
			.and()
			  .formLogin()
			  .loginPage("/auth/loginForm")
			  .loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소로 요청 오는 로그인을 가로챔
			  .defaultSuccessUrl("/")
			  .failureUrl("/");
		//super.configure(http);
		//System.out.println("sadsaddaas asd sada sadas das sa configure");
	}
}
