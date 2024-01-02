package com.product.productservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
//@LoadBalancerClient
public class ProductserviceApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("Product Service Has Been Started ...");
		SpringApplication.run(ProductserviceApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProductserviceApplication.class);
	}

}
