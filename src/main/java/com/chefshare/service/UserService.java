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

	// 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화 - > 영속화된 User 오브젝트를 수정
	// select 해서 가져오는 이유는 영속화를 위함
	// 영속화된 오브젝트를 변경하면 자동으로 DB에서 UPDATE를 해준다
	@Transactional
	public void update(User user) {
		User persistence = userRepository.findById(user.getId()).orElseThrow(() -> {
			return new IllegalArgumentException("등록된 회원이 아닙니다");
		});
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistence.setPassword(encPassword);
		persistence.setEmail(user.getEmail());
		// 회원수정 함수 종료 => 서비스 종료 => 트랜젝션 종료 => commit이 자동으로 된다
		// 영속화된 persistence 객체의 변화를 더티체킹하여 update

	
	}
//	@Transactional(readOnly = true)
//	public User login(User user) {
//		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//	}
}
