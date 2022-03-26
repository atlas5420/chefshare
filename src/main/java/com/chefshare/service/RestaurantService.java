package com.chefshare.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chefshare.model.Image;
import com.chefshare.model.Restaurant;
import com.chefshare.model.User;
import com.chefshare.repository.ImageRepository;
import com.chefshare.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private ImageRepository imageRepository;
	
	@Transactional
	public void wirte(Restaurant restaurant, User user) {
		restaurant.setUser(user);
		restaurant.setEmail(user);
		restaurantRepository.save(restaurant);
	}

	@Transactional
	public void fileSave(Image image, MultipartFile file) throws IOException {
		String path = System.getProperty("user.dir") + "\\imagetest";
		UUID uuid = UUID.randomUUID();
		String fileName = uuid + "_" + file.getOriginalFilename();
		File savefile = new File(path, fileName);
		file.transferTo(savefile);
		image.setFilename(fileName);
		image.setFilepath(path);
		System.out.println("service test");
		System.out.println(file.getOriginalFilename());
		imageRepository.save(image);	
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
		return restaurantRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 읽기 실패");
		});
	}

	@Transactional
	public void update(int id, Restaurant requestBoard) {
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> {
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
