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
        log.info("Data has been read from file");
        List<Cone> listCone = new ArrayList<>();

        for (String line : lines) {
            if (dataValidator.validate(line)) {
                log.info("Data valid");
                Cone cone = coneCreator.create(line);
                log.info("Cone created");
                if(cone!=null) {
                    listCone.add(cone);
                    log.info("Cone added to list");
                }
            }
        }
        return listCone;
    }
}