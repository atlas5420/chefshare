package com.chefshare.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Service
public class fileService {

	@Transactional
	public void test(MultipartFile file) throws IllegalStateException, IOException {
		file.transferTo(new File("d:\\" + file.getOriginalFilename()));
	}
}
