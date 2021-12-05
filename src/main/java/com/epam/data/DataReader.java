package com.epam.data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class DataReader {

    private static final Logger LOGGER = Logger.getLogger(DataReader.class);

    public List<String> read(String path) throws DataProcessingException {

        List<String> listString = new ArrayList<>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(path));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                listString.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new DataProcessingException("Incorrect file path" + path, e);
        } catch (IOException e) {
            throw new DataProcessingException("Cannot read file", e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOGGER.warn("Cannot close reader", e);
                }
            }
        }
        return listString;
    }
}
