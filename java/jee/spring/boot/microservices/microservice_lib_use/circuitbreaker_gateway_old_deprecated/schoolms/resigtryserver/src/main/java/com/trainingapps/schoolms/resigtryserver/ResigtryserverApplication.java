package com.trainingapps.schoolms.resigtryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ResigtryserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResigtryserverApplication.class, args);
	}

}
