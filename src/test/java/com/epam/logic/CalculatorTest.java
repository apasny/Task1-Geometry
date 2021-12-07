package com.epam.logic;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;
import com.epam.entities.Octant;
import org.junit.Assert;
import org.junit.Test;

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
    public void testDefineOctantShouldDefineCorrectOctant(){
        //given
        Calculator calculator = new Calculator();

        double x = 1;
        double y = -1;
        double z = 1;

        //when
        Octant result = calculator.defineOctant(x,y,z);

        //then
        Assert.assertEquals(Octant.FOURTH,result);
    }

    @Test
    public void testIsCrossingPlaneShouldReturnTrueIfBaseAndApexInDifferentOctant(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(-5,-6,-7);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        boolean result = calculator.isCrossingPlane(cone);

        //then
        Assert.assertTrue(result);
    }

}
