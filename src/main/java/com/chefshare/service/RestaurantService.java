package com.chefshare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chefshare.model.Restaurant;
import com.chefshare.model.User;
import com.chefshare.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Transactional
	public void wirte(Restaurant restaurant, User user) {
		restaurant.setUser(user);
		restaurant.setEmail(user);
		restaurantRepository.save(restaurant);
	}
	
	@Transactional
	public List<Restaurant> list() {
		return restaurantRepository.findAll();
	}
	
	@Transactional
	public Restaurant read(int id) {
		return restaurantRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 읽기 실패");
		});
	}
}
