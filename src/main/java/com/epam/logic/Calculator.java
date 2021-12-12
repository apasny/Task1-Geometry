package com.epam.logic;

import com.epam.entities.*;

public class Calculator {

    public double calculateArea(Cone cone) {
        return Math.PI * cone.getRadius() * (cone.getRadius() + calculateConeGeneratrix(cone));
    }

    public double calculateVolume(Cone cone) {
        return Math.PI * calculateConeHeight(cone) * Math.pow(cone.getRadius(), 2) / 3;
    }

    public double calculateConeHeight(Cone cone) {
        return Math.sqrt(Math.pow(cone.getApex().getX() - cone.getBaseCenter().getX(), 2) +
                Math.pow(cone.getApex().getY() - cone.getBaseCenter().getY(), 2) +
                Math.pow(cone.getApex().getZ() - cone.getBaseCenter().getZ(), 2));
    }

    public double calculateConeGeneratrix(Cone cone) {
        return Math.sqrt(Math.pow(cone.getRadius(), 2) + Math.pow(calculateConeHeight(cone), 2));
    }

    public boolean isConeBaseOnCoordinatePlane(Cone cone) {
        BaseCenter baseCenter = cone.getBaseCenter();
        Apex apex = cone.getApex();
        if (baseCenter.getX() == 0 && baseCenter.getY() == apex.getY() && baseCenter.getZ() == apex.getZ() && apex.getX() != 0) {
            return true;
        } else if (baseCenter.getY() == 0 && baseCenter.getX() == apex.getX() && baseCenter.getZ() == apex.getZ() && apex.getY() != 0) {
            return true;
        } else {
            return baseCenter.getZ() == 0 && baseCenter.getX() == apex.getX() && baseCenter.getY() == apex.getY() && apex.getZ() != 0;
        }
    }

    public Octant defineOctant(double x, double y, double z) {

        if (x > 0 && y > 0 && z > 0) {
            return Octant.FIRST;
        }
        if (x < 0 && y > 0 && z > 0) {
            return Octant.SECOND;
        }
        if (x < 0 && y < 0 && z > 0) {
            return Octant.THIRD;
        }
        if (x > 0 && y < 0 && z > 0) {
            return Octant.FOURTH;
        }
        if (x > 0 && y > 0 && z < 0) {
            return Octant.FIFTH;
        }
        if (x < 0 && y > 0 && z < 0) {
            return Octant.SIXTH;
        }
        if (x < 0 && y < 0 && z < 0) {
            return Octant.SEVENTH;
        }
        if (x > 0 && y < 0 && z < 0) {
            return Octant.EIGHTH;
        }

        return null;
    }

    public boolean isCrossingPlane(Cone cone) {

        BaseCenter baseCenter = cone.getBaseCenter();
        Apex apex = cone.getApex();

        Octant baseCenterOctant = defineOctant(baseCenter.getX(), baseCenter.getY(), baseCenter.getZ());
        Octant apexOctant = defineOctant(apex.getX(), apex.getY(), apex.getZ());

        return baseCenterOctant != apexOctant;
    }

    public double calculateConeVolumeRatio(Cone cone) {

        Apex apex = cone.getApex();

        if (isCrossingPlane(cone)) {
            double ctgAngle = cone.getRadius() / calculateConeHeight(cone);
            double frustumConeUpperRadius;
            double frustumConeHeight;

            switch (isHeightOrthogonalToPlane(cone)) {
                case OX:
                    frustumConeUpperRadius = cone.getRadius() - ctgAngle * apex.getZ();
                    frustumConeHeight = apex.getZ();
                    break;
                case OY:
                    frustumConeUpperRadius = cone.getRadius() - ctgAngle * apex.getX();
                    frustumConeHeight = apex.getX();
                    break;
                case OZ:
                    frustumConeUpperRadius = cone.getRadius() - ctgAngle * apex.getY();
                    frustumConeHeight = apex.getY();
                    break;
                default:
                    return 0;
            }
            double frustumConeVolume = (Math.PI * frustumConeHeight * Math.pow(cone.getRadius(), 2)) / 3 +
                    cone.getRadius() * frustumConeUpperRadius + Math.pow(frustumConeUpperRadius, 2);

            double smallConeVolume = calculateVolume(cone) - frustumConeVolume;

            return frustumConeVolume / smallConeVolume;

        }

        return 0;

    }

    public Axis isHeightOrthogonalToPlane(Cone cone) {

        Apex apex = cone.getApex();

        double sinFiOX = Math.abs(apex.getX() / (Math.sqrt(1) * Math.sqrt(Math.pow(apex.getX(), 2) + Math.pow(apex.getY(), 2) + Math.pow(apex.getZ(), 2))));
        double sinFiOY = Math.abs(apex.getY() / (Math.sqrt(1) * Math.sqrt(Math.pow(apex.getX(), 2) + Math.pow(apex.getY(), 2) + Math.pow(apex.getZ(), 2))));
        double sinFiOZ = Math.abs(apex.getZ() / (Math.sqrt(1) * Math.sqrt(Math.pow(apex.getX(), 2) + Math.pow(apex.getY(), 2) + Math.pow(apex.getZ(), 2))));

        if (sinFiOX == 1) {
            return Axis.OX;
        }
        if (sinFiOY == 1) {
            return Axis.OY;
        }
        if (sinFiOZ == 1) {
            return Axis.OZ;
        }

        return null;

    }
}
