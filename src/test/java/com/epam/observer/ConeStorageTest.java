package com.epam.observer;

import com.epam.entities.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class ConeStorageTest {

    @Test
    public void testUpdateShouldUpdateWhenSetNewCoordinate() {
        // given
        double radius = 1;
        UUID id = UUID.randomUUID();
        BaseCenter baseCenter = new BaseCenter(2, 3, 4);
        Apex apex = new Apex(5, 6, 7);
        Cone cone = new Cone(baseCenter, radius, apex);
        ConeIdentifiable coneIdentifiable = new ConeIdentifiable(id, cone);
        Parameters parameters = new Parameters(5.441398, 19.765338);

        ConeStorage.getInstance().update(coneIdentifiable);

        //when
        Parameters result = ConeStorage.getInstance().getCalculatedVolumeAndArea().get(coneIdentifiable.getId());

        //then
        Assert.assertEquals(parameters.getArea(), result.getArea(), 0.00001);
        Assert.assertEquals(parameters.getVolume(), result.getVolume(), 0.00001);
    }
}

