package com.epam.data;

import com.epam.entities.Cone;
import java.util.ArrayList;
import java.util.List;

import com.epam.entities.ConeIdentifiable;
import org.apache.log4j.Logger;

public class Director {

    private static final Logger LOGGER = Logger.getLogger(Director.class);

    private final IdGenerator idGenerator = new IdGenerator();

    private final DataReader dataReader;
    private final ConeCreator coneCreator;
    private final DataValidator dataValidator;

    public Director(DataReader dataReader, ConeCreator coneCreator, DataValidator dataValidator) {
        this.dataReader = dataReader;
        this.coneCreator = coneCreator;
        this.dataValidator = dataValidator;
    }

    public List<ConeIdentifiable> processData(String path) throws DataProcessingException {

        LOGGER.info("Data processing started");
        List<String> lines = dataReader.read(path);
        LOGGER.info("Data has been read from file");
        List<ConeIdentifiable> listCone = new ArrayList<>();

        for (String line : lines) {
            if (dataValidator.validate(line)) {
                LOGGER.info("Data valid");
                ConeIdentifiable coneIdentifiable = coneCreator.create(line);
                LOGGER.info("Cone created");
                if (coneIdentifiable != null) {
                    listCone.add(coneIdentifiable);
                    LOGGER.info("Cone added to list");
                } else {
                    LOGGER.warn("SHAPE IS NOT A CONE!");
                }
            }
        }
        return listCone;
    }
}