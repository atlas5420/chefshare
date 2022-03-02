package com.chefshare.config.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chefshare.model.User;
import com.chefshare.repository.UserRepository;

@Service
public class PrincipalDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User principal = userRepository.findByUsername(username).orElseThrow(() -> {
			System.out.println("확인1"+username);
			return new UsernameNotFoundException("가입되어있지 않은 아이디 입니다");
		});
		System.out.println("확인2"+username);
		return new PrincipalDetail(principal); // 시큐리티 세션에 유저정보 저장
		
	}

}
