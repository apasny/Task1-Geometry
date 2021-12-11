package com.epam.entities;

import java.util.Objects;

public class BaseCenter {

    private final double x;
    private final double y;
    private final double z;

    public BaseCenter(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCenter that = (BaseCenter) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0 && Double.compare(that.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "BaseCenter{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}