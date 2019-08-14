package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.CatalogProperties;

@RestController
public class ConfigPropertiesViewController {

	@Autowired
	private Environment env;
	

	@Autowired
	private CatalogProperties properties;

	@GetMapping("/config-properties")
	public CatalogProperties view() {
		
		System.out.println(env.getProperty("domain"));
		System.out.println(env.getProperty("location"));
		
		return properties;
	}

}
