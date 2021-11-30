package com.epam.dataprocessing;

import com.epam.entities.Cone;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import java.util.List;

public class DirectorTest {

    @Test
    public void testProcessDataShouldReturnListOfCones() throws DataProcessingException {
        //given
        DataReader dataReader = Mockito.mock(DataReader.class);
        ConeCreator coneCreator = Mockito.mock(ConeCreator.class);
        DataValidator dataValidator = Mockito.mock(DataValidator.class);

        Director director = new Director(dataReader,coneCreator,dataValidator);

        //when
        List<Cone> result = director.processData("");

        //then
        Assert.assertEquals(0,result.size());
    }

}
