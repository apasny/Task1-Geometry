package com.epam.data;

public class DataProcessingException extends Exception {
    public DataProcessingException(String message, Exception err){
        super(message,err);
    }
}
