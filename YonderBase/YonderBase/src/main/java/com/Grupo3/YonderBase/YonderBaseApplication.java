package com.Grupo3.YonderBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Grupo3.YonderBase"})
public class YonderBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(YonderBaseApplication.class, args);
	}

}
