package com.example.service;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.client.CartFeignClient;
import com.example.model.CartLine;
import com.example.model.Order;
import com.example.repository.OrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartFeignClient cartFeignClient;

	@HystrixCommand(fallbackMethod = "backupOrder")
	public Order newOrder(String cartId) {

		CartLine[] cartLines = cartFeignClient.getCart("Nag");

		double totalAmount = Arrays.stream(cartLines).mapToDouble(line -> line.getQty() * line.getItem().getPrice())
				.sum();
		Order order = new Order();
		order.setTotalAmount(totalAmount);
		order.setDateTime(LocalDateTime.now());
		order = orderRepository.save(order);
		cartFeignClient.clearCart("Nag");

		return order;

	}

	public Order backupOrder(String cartId) {
		System.out.println("backupOrder");
		Order order = new Order();
		order.setTotalAmount(0.0);
		order.setDateTime(LocalDateTime.now());
		order = orderRepository.save(order);
		return order;
	}

}
