package com.mylearn.microservices.circuitbraker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CircuitBrakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBrakerApplication.class, args);
	}

	@Bean
	public WebClient getWebclient()
	{
		return  WebClient.builder().baseUrl("http://localhost:8085").build();
	}
}
