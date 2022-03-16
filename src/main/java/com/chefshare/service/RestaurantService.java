package com.chefshare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	
	@Transactional(readOnly = true)
	public Page<Restaurant> indexlist(Pageable pageable) {
		return restaurantRepository.findAll(pageable);
	}
	
	@Transactional
	public Restaurant read(int id) {
		return restaurantRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 읽기 실패");
		});
	}
	
	@Transactional
	public void update(int id, Restaurant requestBoard) {
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 읽기 실패");
		});
		restaurant.setTitle(requestBoard.getTitle());
		restaurant.setContent(requestBoard.getContent());
		restaurant.setCuisine(requestBoard.getCuisine());
		restaurant.setRegion(requestBoard.getRegion());
		restaurant.setAddress(requestBoard.getAddress());
	}
	
	@Transactional
	public void delete(int id) {
		restaurantRepository.deleteById(id);
	}
}
