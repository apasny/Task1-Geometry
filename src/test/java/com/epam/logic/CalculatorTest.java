package com.epam.logic;

import com.epam.entities.*;
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

    @Test
    public void testIsConeBaseOnCoordinatePlaneShouldReturnTrueIfBaseOnPlane(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(5,5,0);
        Apex apex = new Apex(5,5,1);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        boolean result = calculator.isConeBaseOnCoordinatePlane(cone);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void testIsHeightOrthogonalToPlaneShouldReturnTrue(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(5,5,5);
        Apex apex = new Apex(0,0,10);
        Cone cone = new Cone(baseCenter,radius,apex);

        System.out.println(calculator.isHeightOrthogonalToPlane(cone));

        //when
        Axis result = calculator.isHeightOrthogonalToPlane(cone);

        //then
        Assert.assertEquals(Axis.OZ,result);
    }

    @Test
    public void testCalculateConeVolumeRatioShouldReturnRatio(){
        //given
        Calculator calculator = new Calculator();

        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(5,5,5);
        Apex apex = new Apex(0,0,-5);
        Cone cone = new Cone(baseCenter,radius,apex);

        //when
        double result = calculator.calculateConeVolumeRatio(cone);

        //then
        Assert.assertEquals(0.184749,result,0.0001);
    }

}
