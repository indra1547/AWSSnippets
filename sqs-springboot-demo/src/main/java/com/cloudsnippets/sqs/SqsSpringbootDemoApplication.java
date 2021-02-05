package com.cloudsnippets.sqs;

/*
 * This is the demo application to post and listen messages in AWS-SQS(Standard queue)
 * 
 * */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SqsSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsSpringbootDemoApplication.class, args);
	}

}
