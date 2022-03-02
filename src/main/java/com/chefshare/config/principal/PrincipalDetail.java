package com.chefshare.config.principal;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chefshare.model.User;

import lombok.Getter;

//스프링 시큐리티가 로그인 요청을 완료하면 UserDetails 타입의 오브젝트를 세션에 저장해준다
@Getter
public class PrincipalDetail implements UserDetails {
	
	private User user;

	public PrincipalDetail(User user) {
		this.user = user;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//만료된 계정인지 (true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//계정이 잠겨있는지 (true:언락됨)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//비밀번호 만료되었는지 (true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//계정 활성화 (true:활성)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//계정 권한
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_" + user.getRole(); });
		//스프링에서 ROLE을 받을때 꼭 써줘야함 "ROLE_"
		return collectors; 
	}
	
}
