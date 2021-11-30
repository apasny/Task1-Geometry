package com.epam.conecreator;

import com.epam.cone.Apex;
import com.epam.cone.BaseCenter;
import com.epam.cone.Cone;

public class ConeCreator {

    public Cone create(String line) {

        String[] splitNumbers = line.split(" ");
        double[] coordinates = new double[splitNumbers.length];

        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i]=Double.parseDouble(splitNumbers[i]);
        }

        double radius = coordinates[0];

        BaseCenter baseCenter = new BaseCenter(coordinates[1],coordinates[2],coordinates[3]);

        Apex apex = new Apex(coordinates[4],coordinates[5],coordinates[6]);

        return new Cone(baseCenter,radius,apex);

    }
}
