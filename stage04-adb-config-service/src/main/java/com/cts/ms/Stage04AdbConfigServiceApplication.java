package com.cts.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Stage04AdbConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Stage04AdbConfigServiceApplication.class, args);
	}

}
