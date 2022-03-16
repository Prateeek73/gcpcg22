package com.trainingapp.javaconfigdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
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

    }
}
