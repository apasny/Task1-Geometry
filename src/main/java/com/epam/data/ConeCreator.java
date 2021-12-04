package com.epam.data;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;
import com.epam.logic.Calculator;
import org.apache.log4j.Logger;

public class ConeCreator {

    private static final Logger log = Logger.getLogger(ConeCreator.class);

    public Cone create(String line) {

        String splitter = " ";
        String[] splittedLine = line.split(splitter);

        double radius = Double.parseDouble(splittedLine[0]);
        double baseCenterX = Double.parseDouble(splittedLine[1]);
        double baseCenterY = Double.parseDouble(splittedLine[2]);
        double baseCenterZ = Double.parseDouble(splittedLine[3]);
        double apexX = Double.parseDouble(splittedLine[4]);
        double apexY = Double.parseDouble(splittedLine[5]);
        double apexZ = Double.parseDouble(splittedLine[6]);

        boolean isCone = Calculator.isCone(radius, baseCenterX, baseCenterY, baseCenterZ, apexX, apexY, apexZ);

        BaseCenter baseCenter = new BaseCenter(baseCenterX, baseCenterY, baseCenterZ);
        Apex apex = new Apex(apexX, apexY, apexZ);

        return isCone ? new Cone(baseCenter, radius, apex):null;
    }
}

