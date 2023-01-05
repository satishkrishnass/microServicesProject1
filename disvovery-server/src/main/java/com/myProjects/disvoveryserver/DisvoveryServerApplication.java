package com.myProjects.disvoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DisvoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisvoveryServerApplication.class, args);
	}

}
