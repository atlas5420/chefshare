package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.service.RestaurantService;

@Controller
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@GetMapping("/restaurant")
	public String restaurant(Model model) {
		model.addAttribute("restaurants", restaurantService.list());
		return "/board/restaurant/restaurant";
	}

	@GetMapping("/restaurant/write")
	public String wirte(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/board/restaurant/writeForm";
	}

	@GetMapping("/restaurant/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("restaurant", restaurantService.read(id));
		return "/board/restaurant/contentDetail";
	}

	@GetMapping("/restaurant/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("restaurant", restaurantService.read(id));
		return "/board/restaurant/updateForm";
	}
 
}
