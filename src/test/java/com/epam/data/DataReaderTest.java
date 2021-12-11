package com.epam.data;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class DataReaderTest {

    @Test
    public void testReadLinesFromFile() throws DataProcessingException {
        //given
        DataReader dataReader = new DataReader(){};
        File file = new File("./src/test/resources/input.txt");
        String absolutePath = file.getAbsolutePath();

        //when
        List<String> result = dataReader.read(absolutePath);
        List<String> expected = Collections.singletonList("-1.0 2.0 3.0 4.0 5.0 6.0 7.0");

        //then
        Assert.assertEquals(expected,result);

    }

    @Test(expected = DataProcessingException.class)
    public void testReadShouldThrowException() throws DataProcessingException {
        //given
        DataReader dataReader = new DataReader(){};
        File file = new File("");
        String absolutePath = file.getAbsolutePath();

        //when
        dataReader.read(absolutePath);

    }

}
