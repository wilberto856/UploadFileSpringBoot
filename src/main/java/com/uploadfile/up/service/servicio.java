package com.uploadfile.up.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class servicio {

//	private String filesfolder = ".//src//main//resources//files//";
	private String filesfolder = "C://files//";
	
	public void saveFile(MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			byte [] bytes = file.getBytes();
			Path path = Paths.get(filesfolder + file.getOriginalFilename());
			Files.write(path, bytes);
		}
		
		
	}
}
