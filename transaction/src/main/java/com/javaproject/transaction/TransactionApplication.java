package com.javaproject.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.javaproject.transaction")

public class TransactionApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}

}
