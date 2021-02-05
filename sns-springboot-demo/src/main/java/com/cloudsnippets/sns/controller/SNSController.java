package com.cloudsnippets.sns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;

@RestController
public class SNSController {
	
	@Autowired
	private AmazonSNSClient amazonSNSClient;
	
	private static final String TOPIC_ARN = "";
	
	@GetMapping("/subscribe/{email}")
	public String subscribeToSNSTopic(@PathVariable String email) {
		
		SubscribeRequest subRequest = new SubscribeRequest(TOPIC_ARN,"email",email);
		amazonSNSClient.subscribe(subRequest);
		return "Please check your mail box";
	}
	
	@GetMapping("/publish/message/{message}")
	public String publishToTopic(@PathVariable String message) {
		
		PublishRequest publishRequest = new PublishRequest(TOPIC_ARN,message,"SNS test message from Spring boot");
		amazonSNSClient.publish(publishRequest);
		return "Message published successfully";
	}

}
