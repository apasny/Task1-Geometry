package com.epam.data;

import com.epam.entities.Cone;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private final DataReader dataReader;
    private final ConeCreator coneCreator;
    private final DataValidator dataValidator;

    public Director(DataReader dataReader, ConeCreator coneCreator, DataValidator dataValidator) {
        this.dataReader = dataReader;
        this.coneCreator = coneCreator;
        this.dataValidator = dataValidator;
    }

    public List<Cone> processData(String path) throws DataProcessingException {

        LOGGER.info("Data processing started");
        List<String> lines = dataReader.read(path);
        LOGGER.info("Data has been read from file");
        List<Cone> listCone = new ArrayList<>();

        for (String line : lines) {
            if (dataValidator.validate(line)) {
                LOGGER.info("Data valid");
                Cone cone = coneCreator.create(line);
                LOGGER.info("Cone created");
                if (cone != null) {
                    listCone.add(cone);
                    LOGGER.info("Cone added to list");
                }
            }
        }
        return listCone;
    }
}