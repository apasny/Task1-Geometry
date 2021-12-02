package com.epam.entities;

public class Parameters {

    private final double volume;
    private final double area;

    public Parameters(double volume, double area) {
        this.volume = volume;
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "volume=" + volume +
                ", area=" + area +
                '}';
    }
}
