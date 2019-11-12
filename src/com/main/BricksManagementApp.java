package com.main

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class BricksManagementApp {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(
				BricksManagementApp.class, args);
	}
}
