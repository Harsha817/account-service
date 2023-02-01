package com.hv.accountService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kafka.kafkaProducer;

@RestController
@RequestMapping("/kafka")
public class messageController {

	
	private kafkaProducer KafkaProducer;
	
	
	
	public messageController() {
		
	}


	public messageController(kafkaProducer kafkaProducer) {
		KafkaProducer = kafkaProducer;
	}
	
	
	// http:localhost:8083/kafka/send?message=salary
	@GetMapping("/send")
	public ResponseEntity<String> sendMsg(@RequestParam("message")String message){
		KafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message sent");
		}
	
}
