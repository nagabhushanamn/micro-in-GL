package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
		return properties;
	}

}
