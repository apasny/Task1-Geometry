package com.epam;

import com.epam.data.*;
import com.epam.entities.Cone;

import java.util.List;

public class Main {
    public static void main(String[] args) throws DataProcessingException {

        String path = "E:\\Programming\\Java\\Task1-Geometry\\src\\main\\resources\\input.txt";


        Director director = new Director(new DataReader(),new ConeCreator(),new DataValidator());

        List<Cone> cones = director.processData(path);


    }
}
