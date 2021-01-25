package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TrackingsheetApplication {
	public static void main(String[] args) {
		InputController.init();
		SpringApplication.run(TrackingsheetApplication.class, args);
		}

}
