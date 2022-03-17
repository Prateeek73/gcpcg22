package com.example.bootdemo.canvas;

import org.springframework.stereotype.Component;

@Component
public class Rectangle implements IShape{

    private double len,breadth;

    public Rectangle(){

    }

    public Rectangle(double len, double breadth){
        this.len = len;
        this.breadth=breadth;
    }

    @Override
    public double area() {
        return len*breadth;
    }

    @Override
    public String toString() {
        return "im a rectangle";
    }
}
