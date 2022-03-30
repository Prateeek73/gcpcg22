package com.trainingapps.schoolms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Configuration
 * @ComponentScan
 * @EnableAutoConfiguration
 *
 */
@SpringBootApplication
public class DemoApplication {
	private static final Logger Log= LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


		Log.debug("***logged using debug");
		Log.info("***logged using info");
		Log.error("***logged using error");
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
