package com.epam.data;

public class ConeValidator {

    public boolean isCone(double radius, double baseCenterX, double baseCenterY, double baseCenterZ, double apexX, double apexY, double apexZ) {
        if(radius > 0) {
            if (baseCenterX != apexX) {
                return true;
            } else if (baseCenterY != apexY) {
                return true;
            } else return baseCenterZ != apexZ;
        }
        return false;
    }

}
