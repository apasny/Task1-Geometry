package com.epam.entities;

import java.util.Objects;

public class Apex {

    private final double x;
    private final double y;
    private final double z;

    public Apex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apex apex = (Apex) o;
        return Double.compare(apex.x, x) == 0 && Double.compare(apex.y, y) == 0 && Double.compare(apex.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return "Apex{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
