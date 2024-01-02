package com.users.userservice;

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
//@CrossOrigin(origins = {"http://127.0.0.1:5500","http://192.168.1.31:5500","*"},originPatterns ={"http://127.0.0.1:5500","http://192.168.1.31:5500","*"})
@CrossOrigin(origins = "*")
public class UserserviceApplication extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(UserserviceApplication.class);
	    }
}
