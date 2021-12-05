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
}
