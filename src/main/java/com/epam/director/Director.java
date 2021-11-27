package com.epam.director;

import com.epam.cone.Cone;
import com.epam.conecreator.ConeCreator;
import com.epam.datareader.DataReader;
import com.epam.datavalidator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class Director {

    DataReader dataReader = new DataReader();
    ConeCreator coneCreator = new ConeCreator();
    DataValidator dataValidator = new DataValidator();

    public List<Cone> read(String path){

        List<String> lines = dataReader.read(path);
        List<Cone> listCone = new ArrayList<>();

        for (String line:lines) {
            if (dataValidator.validate(line)){
                Cone cone = coneCreator.create(line);
                listCone.add(cone);
            }
        }

        return listCone;
    }

}
