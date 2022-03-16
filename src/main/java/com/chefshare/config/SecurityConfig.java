package com.chefshare.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.chefshare.config.principal.PrincipalDetailService;

@Configuration //ioc ���� ����
@EnableWebSecurity // ��ť��Ƽ ���� �߰�
@EnableGlobalMethodSecurity(prePostEnabled = true) // Ư�� �ּ� �����ϸ� ���� �� ������ �̸� üũ
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean //return ���� �������� ���� �ʿ��Ҷ����� ���
	public BCryptPasswordEncoder encoderPWD() {
		return new BCryptPasswordEncoder();
	}
	
	//��ť��Ƽ �� DB password hash�� ��
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(principalDetailService)
			.passwordEncoder(encoderPWD());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/", "/login/**", "/register/**", "/js/**", "/css/**", "/img/**","/forum", "/forum/{boardId}")
				.permitAll()
				.anyRequest()
				.authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/login/loginProc")
				.defaultSuccessUrl("/")
				.failureUrl("/register");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
}
