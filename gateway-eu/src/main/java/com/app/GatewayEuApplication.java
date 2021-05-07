package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class GatewayEuApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayEuApplication.class, args);
	}

}
