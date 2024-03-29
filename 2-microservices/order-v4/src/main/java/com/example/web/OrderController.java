package com.example.web;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.client.CartFeignClient;
import com.example.model.CartLine;
import com.example.model.Order;
import com.example.repository.OrderRepository;

@CrossOrigin(origins = "*")
@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartFeignClient cartFeignClient;

	@GetMapping("/orders")
	public List<Order> getAll() {
		return orderRepository.findAll();
	}

	@PostMapping("/checkout/{cartId}")
	public ResponseEntity<?> newOrder(@PathVariable String cartId) {

		CartLine[] cartLines = cartFeignClient.getCart("Nag"); // 

		double totalAmount = Arrays.stream(cartLines).mapToDouble(line -> line.getQty() * line.getItem().getPrice())
				.sum();
		Order order = new Order();
		order.setTotalAmount(totalAmount);
		order.setDateTime(LocalDateTime.now());
		order = orderRepository.save(order);
		
		cartFeignClient.clearCart("Nag");
		
		return new ResponseEntity<>(order, HttpStatus.CREATED);

	}

}
