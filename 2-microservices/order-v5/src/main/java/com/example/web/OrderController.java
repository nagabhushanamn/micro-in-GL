package com.example.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	@GetMapping("/orders")
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@PostMapping("/checkout/{cartId}")
	public ResponseEntity<?> newOrder(@PathVariable String cartId) {
		Order order = orderService.newOrder(cartId);
		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

}
