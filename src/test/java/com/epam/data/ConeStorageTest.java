package com.epam.data;

import com.epam.entities.*;
import org.junit.Assert;
import org.junit.Test;

public class ConeStorageTest {

    @Test
    public void testUpdateShouldUpdateWhenSetNewCoordinate() {
        // Write here your test

        int id = 1;
        double radius = 1;
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        ConeObservable cone = new ConeObservable(id,baseCenter,radius,apex);
        Parameters parameters = new Parameters(5.441398,19.765338);

        ConeStorage.getInstance().update(cone);

        //when
        Parameters result = ConeStorage.getInstance().getCalculatedVolumeAndArea().get(cone.getId());

        //then
        Assert.assertEquals(parameters.getArea(),result.getArea(),0.00001);
        Assert.assertEquals(parameters.getVolume(),result.getVolume(),0.00001);
    }
}

