package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chefshare.service.BoardService;

@Controller
public class IndexController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping({ "", "/" })
	public String index() {
		return "index";
	}
	
	@GetMapping("/main")
	private String mainContent() {
		
		return "/layout/main";
	}
}
