package com.product.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
public class ProductserviceApplication {

	public static void main(String[] args) {
		System.out.println("Product Service Has Been Started ...");
		SpringApplication.run(ProductserviceApplication.class, args);
	}

}
