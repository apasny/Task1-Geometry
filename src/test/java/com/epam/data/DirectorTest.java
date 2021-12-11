package com.epam.data;

import com.epam.entities.Apex;
import com.epam.entities.BaseCenter;
import com.epam.entities.Cone;
import com.epam.entities.ConeIdentifiable;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class DirectorTest {

    @Test
    public void testProcessDataShouldReturnListOfCones() throws DataProcessingException {
        //given
        DataReader dataReader = Mockito.mock(DataReader.class);
        ConeCreator coneCreator = Mockito.mock(ConeCreator.class);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);

        String path = "";
        double radius = 1;
        UUID id = UUID.randomUUID();
        BaseCenter baseCenter = new BaseCenter(2,3,4);
        Apex apex = new Apex(5,6,7);
        Cone cone = new Cone(baseCenter,radius,apex);
        ConeIdentifiable coneIdentifiable = new ConeIdentifiable(id,cone);
        List<String> responseLine = Collections.singletonList("1.0 2.0 3.0 4.0 5.0 6.0 7.0");

        Mockito.when(dataReader.read(path)).thenReturn(responseLine);
        Mockito.when(coneCreator.create(responseLine.get(0))).thenReturn(coneIdentifiable);
        Mockito.when(dataValidator.validate(responseLine.get(0))).thenReturn(true);

        Director director = new Director(dataReader,coneCreator,dataValidator);

        //when
        List<ConeIdentifiable> result = director.processData(path);

        //then
        Assert.assertEquals(coneIdentifiable,result.get(0));
    }

}
