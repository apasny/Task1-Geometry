package com.epam.dataprocessing;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    @Test
    public void testCreateConeShouldCreateCone () {
        //given
        ConeCreator coneCreator = new ConeCreator(){};
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        double radius = 1;

        //when
        Cone result = coneCreator.create("1.0 2.0 3.0 4.0 5.0 6.0 7.0");
        Cone expected = new Cone(baseCenter,radius,apex);

        //then
        Assert.assertEquals(expected, result);

    }

}
