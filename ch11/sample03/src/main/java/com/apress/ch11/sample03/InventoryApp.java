package com.apress.ch11.sample03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class InventoryApp {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApp.class, args);
	}
}
