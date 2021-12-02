package com.epam.data;

import com.epam.entities.Cone;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Director {

    private static final Logger log = Logger.getLogger(Director.class);

    private final DataReader dataReader;
    private final ConeCreator coneCreator;
    private final DataValidator dataValidator;

    Director (DataReader dataReader, ConeCreator coneCreator, DataValidator dataValidator) {
        this.dataReader = dataReader;
        this.coneCreator = coneCreator;
        this.dataValidator = dataValidator;
    }

    public List<Cone> processData(String path) throws DataProcessingException {
        log.info("Data processing started");

        List<String> lines = dataReader.read(path);
        List<Cone> listCone = new ArrayList<>();

        for (String line : lines) {
            if (dataValidator.validate(line)) {
                Cone cone = coneCreator.create(line);
                listCone.add(cone);
            }
        }
        return listCone;
    }
}