package com.epam.data;

import com.epam.entities.Cone;
import com.epam.entities.ConeIdentifiable;
import org.junit.Assert;
import org.junit.Test;

public class ConeCreatorTest {

    @Test
    public void testCreateConeShouldCreateConeIfShapeIsACone() {
        //given
        ConeCreator coneCreator = new ConeCreator();
        ConeIdentifiable coneIdentifiable = coneCreator.create("1.0 2.0 3.0 4.0 5.0 6.0 7.0");

        //when
        double result = coneIdentifiable.getRadius();

        //then
        Assert.assertEquals(1, result, 0.000001);
    }

    @Test
    public void testCreateConeShouldReturnNullIfShapeIsNotACone() {
        //given
        ConeCreator coneCreator = new ConeCreator();

        //when
        Cone result = coneCreator.create("0 2.0 3.0 4.0 5.0 6.0 7.0");

        //then
        Assert.assertNull(result);
    }

}
