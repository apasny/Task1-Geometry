package com.epam.dataprocessing;

import com.epam.entities.Cone;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

public final class Director {

    private static final Logger log = Logger.getLogger(Director.class);

    private final DataReader dataReader;
    private final ConeCreator coneCreator;
    private final DataValidator dataValidator;

    Director(DataReader dataReader, ConeCreator coneCreator, DataValidator dataValidator) {
        this.dataReader = dataReader;
        this.coneCreator = coneCreator;
        this.dataValidator = dataValidator;
    }

    public List<Cone> processData(String path) throws DataProcessingException {
        log.info("Data processing started");

        List<String> lines = this.dataReader.read(path);
        List<Cone> listCone = new ArrayList<>();

            if (dataValidator.validate(line)) {
                Cone cone = this.coneCreator.create(line);
                listCone.add(cone);
            }

        return listCone;
    }
}