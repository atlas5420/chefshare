package com.chefshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.chefshare.config.principal.PrincipalDetail;
import com.chefshare.model.Board;
import com.chefshare.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/forum")
	public String board(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("boards", boardService.list(pageable));
		return "/board/forum/board";
	}

	@GetMapping("/forum/wirte")
	public String write(@AuthenticationPrincipal PrincipalDetail principal) {
		return "/board/forum/writeForm";
	}
	
	@GetMapping("/forum/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.read(id));
		return "/board/forum/contentDetail";
	}
	
	@GetMapping("/forum/update/{id}")
	public String update(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.read(id));
		return "/board/forum/updateForm";
	}
	
	@GetMapping("/forum/search")
	public String search(@RequestParam(value = "search", required=false) String search, Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> searchList = boardService.search(search, pageable);
		model.addAttribute("searchList", searchList);
		 return "/board/forum/search";
	} 
}
