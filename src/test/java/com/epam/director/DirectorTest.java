package com.epam.director;

import com.epam.cone.Cone;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class DirectorTest {

    @Test
    public void testReadShouldReturnListOfCones(){
        //given
        Director director = new Director();
        File file = new File("src/test/resources/input.txt");
        String absolutePath = file.getAbsolutePath();

        //when
        List<Cone> result=director.read(absolutePath);

        //then
        Assert.assertEquals(0,result.size());
    }

}
