package com.chefshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chefshare.model.RoleType;
import com.chefshare.model.User;
import com.chefshare.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Transactional
	public void register(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}

	// �����ÿ��� ���Ӽ� ���ؽ�Ʈ User ������Ʈ�� ����ȭ - > ����ȭ�� User ������Ʈ�� ����
	// select �ؼ� �������� ������ ����ȭ�� ����
	// ����ȭ�� ������Ʈ�� �����ϸ� �ڵ����� DB���� UPDATE�� ���ش�
	@Transactional
	public void update(User user) {
		User persistence = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("��ϵ� ȸ���� �ƴմϴ�");
		});
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistence.setPassword(encPassword);
		persistence.setEmail(user.getEmail());
		// ȸ������ �Լ� ���� => ���� ���� => Ʈ������ ���� => commit�� �ڵ����� �ȴ�
		// ����ȭ�� persistence ��ü�� ��ȭ�� ��Ƽüŷ�Ͽ� update

	
	}
//	@Transactional(readOnly = true)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
