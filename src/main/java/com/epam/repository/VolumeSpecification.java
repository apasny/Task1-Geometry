package com.epam.repository;

import com.epam.entities.ConeIdentifiable;
import com.epam.logic.Calculator;

public class VolumeSpecification implements Specification {

    private final double lowerBound;
    private final double upperBound;

    private final Calculator calculator = new Calculator();

    public VolumeSpecification(double lowerBound, double upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean specified(ConeIdentifiable cone) {
        return (calculator.calculateVolume(cone) > lowerBound) && (calculator.calculateVolume(cone) < upperBound);
    }
}
