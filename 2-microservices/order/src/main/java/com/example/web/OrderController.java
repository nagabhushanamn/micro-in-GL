package com.example.web;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.CartLine;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/orders")
	public List<Order> getAll() {
		return orderRepository.findAll();
	}
	
	@PostMapping("/checkout/{cartId}")
	public Order newOrder(@PathVariable String cartId) {

		String cartServiceUrl = "http://localhost:8184/cart/Nag";

		ResponseEntity<CartLine[]> responseEntity = restTemplate.getForEntity(cartServiceUrl, CartLine[].class);
		CartLine[] cartLines = responseEntity.getBody();

		double totalAmount = 
				Arrays.stream(cartLines)
				.mapToDouble(line -> line.getQty() * line.getItem().getPrice())
				.sum();

		Order order = new Order();
		order.setTotalAmount(totalAmount);
		order.setDateTime(LocalDateTime.now());
		order=orderRepository.save(order);
		
		restTemplate.delete("http://localhost:8184/cart/Nag");
		
		return order;
		
		
	}

}
