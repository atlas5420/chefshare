package com.chefshare.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chefshare.model.Image;
import com.chefshare.repository.ImageRepository;

@Service
public class TestService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Transactional
	public void save(MultipartFile file, Image image) throws  IOException {
		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img";
		UUID uuid = UUID.randomUUID(); 
		String fileName = uuid + "_" + file.getOriginalFilename();
		File savefile = new File(path, fileName);
		file.transferTo(savefile);
		image.setFilename(fileName);
		image.setFilepath(path);
		System.out.println("service test");
		System.out.println(file.getOriginalFilename());
		imageRepository.save(image);
	}
}
