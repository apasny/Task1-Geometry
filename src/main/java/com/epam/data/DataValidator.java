package com.epam.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    public boolean validate(String line) {

        final String regex = "^(\\d\\.\\d\\s)(-?\\d\\.\\d\\s){5}(\\d\\.\\d)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        return matcher.matches();
    }

}
