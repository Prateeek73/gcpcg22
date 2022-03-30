package com.example.bootdemo;

import com.example.bootdemo.canvas.Canvas;
import com.example.bootdemo.canvas.IShape;
import com.example.bootdemo.canvas.Square;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

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
	ConfigurableApplicationContext context=SpringApplication.run(DemoApplication.class, args);
		IShape square = context.getBean("square", IShape.class);
		System.out.println("square=" + square + " area=" + square.area());
		Canvas canvas = context.getBean(Canvas.class);
		System.out.println(canvas);
		IShape shapeInCanvas = canvas.getShape();
		System.out.println("shape in canvas=" + shapeInCanvas);
		canvas.draw();
		System.out.println("about to close container");

		System.out.println("bye");

		Square square1 = context.getBean(Square.class);
		Square square2 = context.getBean(Square.class);
		boolean isSame = square1 == square2;
		System.out.println("is same="+isSame);

		context.close();

		Log.debug("***logged using debug");
		Log.info("***logged using info");
		Log.error("***logged using error");



	}


}
