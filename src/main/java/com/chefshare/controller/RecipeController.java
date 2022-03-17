package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.repository.RecipeRepository;

@Controller
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("/recipe")
	public String recipe(Model model) {
		model.addAttribute("recipe", recipeRepository.findAll());
		return "/board/recipe/recipe";
	}
	
	@GetMapping("/recipe/write")
	public String write(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/board/recipe/writeForm";
	}
}
