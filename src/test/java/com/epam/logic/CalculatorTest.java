package com.epam.logic;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest {

    @Test
    public void testCalculateConeGeneratrixShouldCalculateGeneratrix(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        double result = calculator.calculateConeGeneratrix(cone);

        //then
        Assert.assertEquals(5.291502,result,0.000001);
    }
    @Test
    public void testCalculateConeHeightShouldCalculateHeight(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        double result = calculator.calculateConeHeight(cone);

        //then
        Assert.assertEquals(5.196152,result,0.000001);
    }
    @Test
    public void testCalculateAreaShouldCalculateArea(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        double result = calculator.calculateArea(cone);

        //then
        Assert.assertEquals(19.765338,result,0.000001);
    }
    @Test
    public void testCalculateVolumeShouldCalculateVolume(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        double result = calculator.calculateVolume(cone);

        //then
        Assert.assertEquals(5.441398,result,0.000001);
    }
    @Test
    public void testIsConeShouldReturnTrueIfDateValid(){
        //given
        double radius = 1;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 5;
        double apexY = 6;
        double apexZ = 7;

        //when
        boolean result = Calculator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertTrue(result);
    }
    @Test
    public void testIsConeShouldReturnFalseIfRadiusBelowZero(){
        //given
        double radius = 0;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 5;
        double apexY = 6;
        double apexZ = 7;

        //when
        boolean result = Calculator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertFalse(result);
    }
    @Test
    public void testIsConeShouldReturnFalseIfNoApex(){
        //given
        double radius = 1;
        double baseCenterX = 2;
        double baseCenterY = 3;
        double baseCenterZ = 4;
        double apexX = 2;
        double apexY = 3;
        double apexZ = 4;

        //when
        boolean result = Calculator.isCone(radius,baseCenterX,baseCenterY,baseCenterZ,apexX,apexY,apexZ);

        //then
        Assert.assertFalse(result);
    }
}
