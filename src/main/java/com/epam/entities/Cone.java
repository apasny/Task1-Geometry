package com.epam.entities;

import java.util.Objects;

public class Cone {

    private BaseCenter baseCenter;
    private Apex apex;
    private double radius;

    public Cone(BaseCenter baseCenter, double radius, Apex apex) {
        this.baseCenter = baseCenter;
        this.radius = radius;
        this.apex = apex;
    }

    public void setBaseCenter(BaseCenter baseCenter) {
        this.baseCenter = baseCenter;
    }

    public void setApex(Apex apex) {
        this.apex = apex;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Apex getApex() {
        return this.apex;
    }

    public BaseCenter getBaseCenter() {
        return this.baseCenter;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cone cone = (Cone) o;
        return Double.compare(cone.radius, radius) == 0 && Objects.equals(baseCenter, cone.baseCenter) && Objects.equals(apex, cone.apex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseCenter, apex, radius);
    }

    public String toString() {
        return "Cone{baseCenter=" + this.baseCenter.toString() + ", apex=" + this.apex.toString() + ", radius=" + this.radius + '}';
    }
}