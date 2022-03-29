package com.example.jobms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.jobms.frontend.FrontEnd;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 */
@SpringBootApplication
public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Main.class, args);
		FrontEnd frontEnd=context.getBean(FrontEnd.class);
		frontEnd.runUI();
//		context.close();
	}
}
