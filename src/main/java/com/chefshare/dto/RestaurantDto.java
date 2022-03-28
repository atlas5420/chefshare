package com.chefshare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantDto {

	private String title;
	private String content;
	private String cuisine;
	private String region;
	private String address;
	private int userId;
	private String email;
	private  int imageId; 
}
