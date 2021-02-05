package com.cloudsnippets.sns;

/*
 * This is the demo application that supports adding email subscription to AWS-SNS topic and 
 * to publish message.
 * 
 * */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnsSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsSpringbootDemoApplication.class, args);
	}

}
