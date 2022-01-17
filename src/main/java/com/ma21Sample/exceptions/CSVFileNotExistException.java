package com.ma21Sample.exceptions;

import java.io.FileNotFoundException;

public class CSVFileNotExistException extends FileNotFoundException {
    public CSVFileNotExistException() {
    }

    public CSVFileNotExistException(String message) {
        super(message);
    }
}
