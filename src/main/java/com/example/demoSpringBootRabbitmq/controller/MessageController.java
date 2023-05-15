package com.example.demoSpringBootRabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoSpringBootRabbitmq.publisher.RabbitMqProducer;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
	
	private RabbitMqProducer producer;
	
	@Autowired
	public MessageController(RabbitMqProducer rabbitMqProducer) {
		this.producer = rabbitMqProducer;
	}
	
	// http://localhost:8080/api/v1/publish?message=hello
	@GetMapping("/publish")
	public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
		producer.sendMessage(message);
		return ResponseEntity.ok("Message sent to Rabbitmq...");
	}
}
