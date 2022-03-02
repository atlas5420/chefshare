package com.chefshare.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.chefshare.config.principal.PrincipalDetail;

@Controller
public class UserController {

	@GetMapping({ "", "/" })
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String joinForm() {
		return "/user/registerForm";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	@GetMapping("/profile")
	public String profile(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/user/profileForm";
	}

}
