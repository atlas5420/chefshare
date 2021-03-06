package com.chefshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chefshare.model.Board;
import com.chefshare.model.User;
import com.chefshare.repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Transactional
	public void write(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}

	@Transactional(readOnly = true)
	public Page<Board> list(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	@Transactional
	public Page<Board> search(String search, Pageable pageable) {
		Page<Board> searchList = boardRepository.findByTitleContaining(search, pageable); 
		return searchList;
	}
	
	@Transactional(readOnly = true)
	public Board read(int id) {
		return boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 읽기 실패");
		});
		
	}
	
	@Transactional
	public void update(int id, Board requestBoard) {
		Board board = boardRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("글 읽기 실패");
		});
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
	}
	
	@Transactional
	public void delete(int id) {
		boardRepository.deleteById(id);
	}
}
