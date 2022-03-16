package com.chefshare.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.dto.ResponseDto;
import com.chefshare.model.Restaurant;
import com.chefshare.service.RestaurantService;

@RestController
public class RestaurantApiController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/restaurant/writeProc")
	public ResponseDto<Integer> save(@RequestBody Restaurant restaurant, @AuthenticationPrincipal PrincipalDetail principal){
		restaurantService.wirte(restaurant, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
