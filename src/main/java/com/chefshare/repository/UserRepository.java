package com.chefshare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefshare.model.User;

//@Repository //��������
public interface UserRepository extends JpaRepository<User, Integer> {
//	User findByUsernameAndPassword(String username, String password);
	Optional<User> findByUsername(String username); // select * from user where username=?1;
}
