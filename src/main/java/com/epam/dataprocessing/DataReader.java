package com.epam.dataprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class DataReader {

    private static final Logger log = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws DataProcessingException {

        List<String> listString = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            for(String line = br.readLine(); line != null; line = br.readLine()) {
                listString.add(line);
            }

            br.close();

            return listString;

        } catch (IOException e) {
            log.error("Incorrect file path");
            throw new DataProcessingException("Incorrect file path", e);
        }
    }
}
