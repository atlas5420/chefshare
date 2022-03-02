package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/board")
	public String board(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.list(pageable));
		return "/board/board";
	}

	@GetMapping("/board/wirte")
	public String write(@AuthenticationPrincipal PrincipalDetail principal) {
		System.out.println("로그인 아이디  : " + principal.getUsername());
		return "/board/writeForm";
	}
	
	@GetMapping("/board/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.read(id));
		return "board/contentDetail";
	}
	
	@GetMapping("/board/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.read(id));
		return "board/updateForm";
	}
}
