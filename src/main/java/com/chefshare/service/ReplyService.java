package com.chefshare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chefshare.dto.ReplyRequestDto;
import com.chefshare.model.Board;
import com.chefshare.model.Reply;
import com.chefshare.model.User;
import com.chefshare.repository.BoardRepository;
import com.chefshare.repository.ReplyRepository;
import com.chefshare.repository.UserRepository;

@Service
public class ReplyService {

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void write(ReplyRequestDto replyRequestDto) {

		User user = userRepository.findById(replyRequestDto.getUserId()).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 등록 실패");
		});

		Board board = boardRepository.findById(replyRequestDto.getBoardId()).orElseThrow(() -> {
			return new IllegalArgumentException("댓글 등록 실패");
		});

		Reply reply = Reply.builder().user(user).board(board).content(replyRequestDto.getContent()).build();
		replyRepository.save(reply);
//		replyRepository.mSave(replyRequestDto.getUserId(), replyRequestDto.getBoardId(), replyRequestDto.getContent());
	}
	
	public void delete(int replyId) {
		replyRepository.deleteById(replyId);
	}
}
