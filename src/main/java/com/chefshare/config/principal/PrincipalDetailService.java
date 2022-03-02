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
			System.out.println("Ȯ��1"+username);
			return new UsernameNotFoundException("���ԵǾ����� ���� ���̵� �Դϴ�");
		});
		System.out.println("Ȯ��2"+username);
		return new PrincipalDetail(principal); // ��ť��Ƽ ���ǿ� �������� ����
		
	}

}
