package com.epam.data;

import com.epam.logic.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class ConeValidatorTest {

    @Test
    public void testIsConeShouldReturnTrueIfDateValid(){
        //given
        ConeValidator coneValidator = new ConeValidator();

        double radius = 1;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 5;
        double apexY = 6;
        double apexZ = 7;

        //when
        boolean result = coneValidator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsConeShouldReturnFalseIfRadiusBelowZero(){
        //given
        ConeValidator coneValidator = new ConeValidator();

        double radius = 0;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 5;
        double apexY = 6;
        double apexZ = 7;

        //when
        boolean result = coneValidator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertFalse(result);
    }
    @Test
    public void testIsConeShouldReturnFalseIfNoApex(){
        //given
        ConeValidator coneValidator = new ConeValidator();

        double radius = 1;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 2;
        double apexY = 3;
        double apexZ = 4;

        //when
        boolean result = coneValidator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertFalse(result);
    }
}
