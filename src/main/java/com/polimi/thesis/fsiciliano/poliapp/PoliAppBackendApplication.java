package com.polimi.thesis.fsiciliano.poliapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class PoliAppBackendApplication {

	public static void main(String[] args) {
	 	AnnotationConfigApplicationContext context =  new AnnotationConfigApplicationContext();
//		context.register(ModelMapper.class);
		SpringApplication.run(PoliAppBackendApplication.class, args);
	}

}
