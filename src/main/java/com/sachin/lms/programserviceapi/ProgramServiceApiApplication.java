package com.sachin.lms.programserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProgramServiceApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProgramServiceApiApplication.class, args);
	}

}
