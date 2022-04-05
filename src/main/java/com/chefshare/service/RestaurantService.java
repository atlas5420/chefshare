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
	public void wirte(Restaurant restaurant, User user, Image image) throws IOException {
		restaurant.setUser(user);
		restaurant.setEmail(user);
		restaurant.setImage(image);
		restaurantRepository.save(restaurant);
	}

	@Transactional
	public void fileSave(MultipartFile file, Image image) throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";
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
	
	public List<Image> image(){
		return imageRepository.findAll();
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
	public void update(int id, Restaurant requestRestaurant, Image image) {
		Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 읽기 실패");
		});
		System.out.println(requestRestaurant.getTitle());
		System.out.println(requestRestaurant.getImage());
		restaurant.setTitle(requestRestaurant.getTitle());
		restaurant.setContent(requestRestaurant.getContent());
		restaurant.setCuisine(requestRestaurant.getCuisine());
		restaurant.setRegion(requestRestaurant.getRegion());
		restaurant.setAddress(requestRestaurant.getAddress());
		restaurant.setImage(image);
	}

	@Transactional
	public void delete(int id) {
		restaurantRepository.deleteById(id);
	}
}
