package com.epam.cone;

public class BaseCenter {

    double x;
    double y;
    double z;

    public BaseCenter(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
