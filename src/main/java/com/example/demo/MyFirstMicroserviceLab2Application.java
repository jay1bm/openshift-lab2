package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class MyFirstMicroserviceLab2Application {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstMicroserviceLab2Application.class, args);
	}

}
