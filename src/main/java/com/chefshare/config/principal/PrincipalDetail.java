package com.chefshare.config.principal;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.chefshare.model.User;

import lombok.Getter;

//������ ��ť��Ƽ�� �α��� ��û�� �Ϸ��ϸ� UserDetails Ÿ���� ������Ʈ�� ���ǿ� �������ش�
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

	//����� �������� (true:����ȵ�)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//������ ����ִ��� (true:�����)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//��й�ȣ ����Ǿ����� (true:����ȵ�)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//���� Ȱ��ȭ (true:Ȱ��)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	//���� ����
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_" + user.getRole(); });
		//���������� ROLE�� ������ �� ������� "ROLE_"
		return collectors; 
	}
	
}
