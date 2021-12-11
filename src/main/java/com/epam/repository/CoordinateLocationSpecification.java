package com.epam.repository;

import com.epam.entities.ConeIdentifiable;
import com.epam.entities.Octant;
import com.epam.logic.Calculator;

public class CoordinateLocationSpecification implements Specification {

    private final Octant octant;

    private final Calculator calculator = new Calculator();

    public CoordinateLocationSpecification(Octant octant) {
        this.octant = octant;
    }

    @Override
    public boolean specified(ConeIdentifiable cone) {

        double baseCenterX = cone.getBaseCenter().getX();
        double baseCenterY = cone.getBaseCenter().getY();
        double baseCenterZ = cone.getBaseCenter().getZ();
        double apexX = cone.getApex().getX();
        double apexY = cone.getApex().getY();
        double apexZ = cone.getApex().getZ();

        return calculator.defineOctant(baseCenterX, baseCenterY, baseCenterZ) == octant &&
                calculator.defineOctant(apexX, apexY, apexZ) == octant;
    }
}
