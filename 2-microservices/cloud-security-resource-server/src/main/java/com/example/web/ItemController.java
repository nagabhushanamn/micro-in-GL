package com.example.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Item;

@RestController
@RequestMapping("/items")
public class ItemController {

	@GetMapping
	public Collection<Item> get() {

		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setId(1);
		item.setName("Veg");
		items.add(item);

		return items;

	}

	@PostMapping
	public Item post(@RequestBody Item item) {
		return item;

	}

}
