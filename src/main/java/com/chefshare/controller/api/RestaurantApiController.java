package com.chefshare.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.dto.ResponseDto;
import com.chefshare.model.Image;
import com.chefshare.model.Restaurant;
import com.chefshare.service.RestaurantService;

@RestController
public class RestaurantApiController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurant/writeProc")
	public ResponseDto<Integer> save(@RequestPart(value = "key") Restaurant restaurant, @AuthenticationPrincipal PrincipalDetail principal, @RequestPart(value = "file") MultipartFile file, Image image) throws IOException {
		System.out.println(restaurant.getTitle());

//		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";
//		UUID uuid = UUID.randomUUID(); 
//		String fileName = uuid + "_" + file.getOriginalFilename();
//		File savefile = new File(path, fileName);
//		file.transferTo(savefile);
//		image.setFilename(fileName);
//		image.setFilepath(path);
//		System.out.println("service test");
//		System.out.println(file.getOriginalFilename());
		
		restaurantService.wirte(restaurant, principal.getUser(), image);
		restaurantService.fileSave(file, image);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@PostMapping("/restaurant/imageProc")
	public void imageSave(@RequestPart(value = "image", required = false)  MultipartFile file, Image image) throws IOException {
		System.out.println(file.getOriginalFilename());
		restaurantService.fileSave(file, image);

		 
	}
	
	@PutMapping("/restaurant/updateProc/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Restaurant restaurant){
		restaurantService.update(id, restaurant); 
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/restaurant/deleteProc/{id}")
	public ResponseDto<Integer> deleteByid(@PathVariable int id){
		restaurantService.delete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
