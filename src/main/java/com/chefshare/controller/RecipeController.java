package com.chefshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

	@GetMapping("/recipe")
	public String recipe() {
		return "/board/recipe/recipe";
	}
}
