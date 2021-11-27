package com.epam.cone;

public class Cone {

    BaseCenter baseCenter;
    Apex apex;
    double radius;

    public Cone(BaseCenter baseCenter, double radius, Apex apex){
        this.baseCenter = baseCenter;
        this.radius = radius;
        this.apex = apex;
    }

    public void setApex(Apex apex) {
        this.apex = apex;
    }

    public void setBaseCenter(BaseCenter baseCenter) {
        this.baseCenter = baseCenter;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Apex getApex() {
        return apex;
    }

    public BaseCenter getBaseCenter() {
        return baseCenter;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "baseCenter=" + baseCenter.toString() +
                ", apex=" + apex.toString() +
                ", radius=" + radius +
                '}';
    }
}
