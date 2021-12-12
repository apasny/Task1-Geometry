package com.epam.observer;

import com.epam.entities.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

public class ConeStorageTest {

    @Test
    public void testUpdateShouldUpdate() {
        // given
        double radius = 1;
        UUID id = UUID.randomUUID();
        BaseCenter baseCenter = new BaseCenter(2, 3, 4);
        Apex apex = new Apex(5, 6, 7);
        Cone cone = new Cone(baseCenter, radius, apex);
        ConeIdentifiable coneIdentifiable = new ConeIdentifiable(id, cone);
        Parameters parameters = new Parameters(5.441398, 19.765338);
        ConeStorage coneStorage = ConeStorage.getInstance();

        coneStorage.update(coneIdentifiable);

        Map<UUID, Parameters> calculatedParameters = coneStorage.getCalculatedVolumeAndArea();

        //when
        Parameters result = calculatedParameters.get(id);

        //then
        Assert.assertEquals(parameters.getArea(), result.getArea(), 0.00001);
        Assert.assertEquals(parameters.getVolume(), result.getVolume(), 0.00001);
    }

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

        ConeStorage coneStorage = ConeStorage.getInstance();

        coneIdentifiable.attach(coneStorage);
        coneStorage.update(coneIdentifiable);

        Map<UUID, Parameters> calculatedParameters = coneStorage.getCalculatedVolumeAndArea();

        coneIdentifiable.setBaseCenter(new BaseCenter(3, 3, 4));

        //when
        Parameters result = calculatedParameters.get(id);

        //then
        Assert.assertNotEquals(parameters.getArea(), result.getArea(), 0.00001);
        Assert.assertNotEquals(parameters.getVolume(), result.getVolume(), 0.00001);
    }
}

