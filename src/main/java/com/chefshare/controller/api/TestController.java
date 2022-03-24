package com.chefshare.controller.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.chefshare.service.fileService;



@Controller
public class TestController {
	
	@Autowired
	public fileService fileService;
	
	@GetMapping("/test")
	public String file() {
		return "test";
	}
	
	@PostMapping("/test/file")
	public String savefile(@RequestPart MultipartFile file) throws IllegalStateException, IOException {
			fileService.test(file);
		return "";
	}
}

