package com.chefshare.controller.api;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chefshare.dto.ResponseDto;
import com.chefshare.model.Image;
import com.chefshare.repository.ImageRepository;
import com.chefshare.service.TestService;

@RestController
public class TestApiController {

	@Autowired
	private TestService testService;
	
	@PostMapping("/test/image")
	public ResponseDto<Integer> tesApi(@RequestParam("file") String index , MultipartFile file, Image image) throws IOException {
		System.out.println("------------");
		System.out.println(file.getOriginalFilename());
		System.out.println("------------");
		
		testService.save(file, image);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
