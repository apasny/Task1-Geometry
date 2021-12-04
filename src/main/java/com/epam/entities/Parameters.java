package com.epam.entities;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parameters that = (Parameters) o;
        return Double.compare(that.volume, volume) == 0 && Double.compare(that.area, area) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, area);
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "volume=" + volume +
                ", area=" + area +
                '}';
    }
}
