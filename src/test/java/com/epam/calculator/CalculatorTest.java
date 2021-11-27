package com.epam.calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculateAreaShouldCalculateArea(){
        //given
        Calculator calculator = new Calculator();
        double radius = 2.0;

        //when
        double result = calculator.calculateArea(radius);

        //then
        Assert.assertEquals(43.98,result,0.01);
    }
}
