package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chefshare.service.BoardService;
import com.chefshare.service.RestaurantService;

@Controller
public class IndexController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping({ "", "/" })
	public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("restaurant", restaurantService.indexlist(pageable));
		model.addAttribute("boards", boardService.list(pageable));
		return "index";
	}
	
	@GetMapping("/main")
	private String mainContent() {
		
		return "/layout/main";
	}
}
