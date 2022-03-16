package com.trainingapp.xmldidemo;


public class Canvas {


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


    public void afterInit(){
        System.out.println("Canvas: inside afterinit , shape="+shape);
    }


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
