package com.example.web;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	private OAuth2ClientContext clientContext;

	@GetMapping("/items")
	public Collection<Item> get() {

		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setId(1);
		item.setName("Veg");
		items.add(item);

		return items;

	}
	
	@RequestMapping("/token")
	public String getToken() {
		String token=clientContext.getAccessToken().getValue();
		return token;
	}
	

	@PostMapping("/items")
	public Item post(@RequestBody Item item) {
		return item;

	}

}
