package com.ar.bootcampJava.ApiFlights;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiFlightsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFlightsApplication.class, args);
	}

}
