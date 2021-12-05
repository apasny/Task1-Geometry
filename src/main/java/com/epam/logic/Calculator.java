package com.epam.logic;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;

public class Calculator {

    public double calculateArea(Cone cone) {
        return Math.PI * cone.getRadius() * (cone.getRadius() + calculateConeGeneratrix(cone));
    }

    public double calculateVolume(Cone cone) {
        return Math.PI * calculateConeHeight(cone) * Math.pow(cone.getRadius(), 2) / 3;
    }

    public double calculateConeHeight(Cone cone) {
        return Math.sqrt(Math.pow(cone.getApex().getX() - cone.getBaseCenter().getX(), 2) + Math.pow(cone.getApex().getY() - cone.getBaseCenter().getY(), 2) + Math.pow(cone.getApex().getZ() - cone.getBaseCenter().getZ(), 2));
    }

    public double calculateConeGeneratrix(Cone cone) {
        return Math.sqrt(Math.pow(cone.getRadius(), 2) + Math.pow(calculateConeHeight(cone), 2));
    }

    public boolean isConeBaseOnCoordinatePlane(Cone cone) {
        BaseCenter baseCenter = cone.getBaseCenter();
        Apex apex = cone.getApex();
        if (baseCenter.getX() == 0 && baseCenter.getY() == apex.getY() && baseCenter.getZ() == apex.getZ()) {
            return true;
        } else if (baseCenter.getY() == 0 && baseCenter.getX() == apex.getX() && baseCenter.getZ() == apex.getZ()) {
            return true;
        } else {
            return baseCenter.getZ() == 0 && baseCenter.getX() == apex.getX() && baseCenter.getY() == apex.getY();
        }
    }
}
