package com.uploadfile.up.control;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.uploadfile.up.service.servicio;

@Controller
public class FileController {

	@Autowired
	private servicio servi;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/upload")
		public ResponseEntity <?> uploadFile(@RequestParam("file") MultipartFile file){
		if(file.isEmpty()) {
			return new  ResponseEntity<Object>("Selecciona Archivo", HttpStatus.OK);
		}
		
		try {
			servi.saveFile(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new  ResponseEntity<Object>("Archivo Subido", HttpStatus.OK); 
	}
	
	
}
