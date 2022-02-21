package com.exception;

public class Parcel {
    public String source;
    public String destination;
    public int netWeightInKg;
    public int totalWeightInKg;

    public Parcel(){
        this.source = "";
        this.destination = "";
        this.netWeightInKg = 0;
        this.totalWeightInKg = 0;
    }

    public Parcel(String source, String destination, int netWeightInKg, int totalWeightInKg){
        this.source = source;
        this.destination = destination;
        this.netWeightInKg = netWeightInKg;
        this.totalWeightInKg = totalWeightInKg;
    }

    public String getSource(){
        return this.source;
    }

    public String getDestination(){
        return this.destination;
    }

    public int getNetWeightInKg(){
        return this.netWeightInKg;
    }

    public int getTotalWeightInKg(){
        return this.totalWeightInKg;
    }

    public void setSource(String source){
        this.source = source;
    }

    public void setDestination(String destination){
        this.destination = destination;
    }

    public void setNetWeightInKg(int netWeightInKg){
        this.netWeightInKg = netWeightInKg;
    }

    public void setTotalWeightInKg(int totalWeightInKg){
        this.totalWeightInKg = totalWeightInKg;
    }
}
