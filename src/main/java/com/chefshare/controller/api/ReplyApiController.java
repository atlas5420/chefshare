package com.chefshare.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chefshare.dto.ReplyRequestDto;
import com.chefshare.dto.ResponseDto;
import com.chefshare.service.ReplyService;

@RestController
public class ReplyApiController {

	@Autowired
	private ReplyService replyService;

	// 데이터를 받을때 controller에서 dto를 만들어서 받는게 일반적임
	@PostMapping("/forum/{boardId}/reply")
	public ResponseDto<Integer> reply(@RequestBody ReplyRequestDto replyRequestDto) {

		replyService.write(replyRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	@DeleteMapping("/forum/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		replyService.delete(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
