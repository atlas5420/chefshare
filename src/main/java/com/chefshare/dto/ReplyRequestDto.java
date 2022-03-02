package com.chefshare.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDto {
	
	private int userId;
	private int boardId;
	private String content;
}
