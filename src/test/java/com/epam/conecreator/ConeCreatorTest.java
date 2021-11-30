package com.epam.conecreator;

import com.epam.cone.Cone;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    @Test
    public void testCreateConeShouldCreateCone () {
        //given
        ConeCreator coneCreator = new ConeCreator(){};

        //when
        Cone result = coneCreator.create("1.0 2.0 3.0 4.0 5.0 6.0 7.0");

        //then
        Assert.assertEquals("Cone{baseCenter={x=2.0, y=3.0, z=4.0}, apex={x=5.0, y=6.0, z=7.0}, radius=1.0}", result.toString());

    }

}
