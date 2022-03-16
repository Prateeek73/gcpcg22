package com.trainingapp.annotationdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Canvas {

    @Autowired
    private IShape shape;

    public Canvas(IShape shape) {
        this.shape = shape;
    }

    public Canvas() {

    }

    public IShape getShape() {
        return shape;
    }

    public void setShape(IShape shape) {
        this.shape = shape;
    }

    @PostConstruct
    public void afterInit(){
        System.out.println("Canvas: inside afterinit , shape="+shape);
    }

    @PreDestroy
    public void save(){
        System.out.println("Canvas: inside save");
    }

    public void draw() {
        double area = shape.area();
        System.out.println("drawing shape with area=" + area);
    }

    @Override
    public String toString() {
       return "ima canvas" ;
    }
}
