package com.trainingapp.xmldidemo;


public class Square implements IShape{


    private double side;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }


    public void afterInit(){
        System.out.println("Square: inside afterinit, side="+side);
    }


    public void save(){
        System.out.println("Square: inside save");
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
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
