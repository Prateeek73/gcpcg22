package com.example.bloggerms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.bloggerms.frontend.FrontEnd;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 */
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);
		FrontEnd frontEnd = context.getBean(FrontEnd.class);
		frontEnd.runUI();
//		context.close();
	}
}
