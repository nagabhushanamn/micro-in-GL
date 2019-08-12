package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.TxrSystemConfiguration;
import com.example.service.TxrService;

public class App {

	public static void main(String[] args) {

		// ------------------------------------------
		// Init/boot
		// ------------------------------------------

		SpringApplication.run(TxrSystemConfiguration.class, args);

	}

}
