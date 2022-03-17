package com.example.bootdemo.canvas;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Square implements IShape{

    @Value("${square.side}")
    private double side;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Square: inside afterinit, side="+side);
    }

    @PreDestroy
    public void save(){
        System.out.println("Square: inside save");
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String toString() {
        return "ima sqaure";
    }
}
