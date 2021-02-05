package com.cloudsnippets.sqs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SQSController {
	
	@Autowired
	private QueueMessagingTemplate queueMessagingTemplate;
	
	@Value("${cloud.aws.end-point.uri}")
	private String queueEndpoint;
	
	@GetMapping("/post/{message}")
	public void postMessageToQueue(@PathVariable String message) {
		queueMessagingTemplate.send(queueEndpoint, MessageBuilder.withPayload(message).build());
	}
	
	@SqsListener("indra-sqs-queue")
	public void pollMessageFromQueue(String message) {
		System.out.println("Polled message: " + message );
	}
	

}
