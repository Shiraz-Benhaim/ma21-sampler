package com.ma21Sample.exceptions;

import lombok.NoArgsConstructor;

import java.io.FileNotFoundException;

@NoArgsConstructor
public class CSVFileNotExistException extends FileNotFoundException {
    public CSVFileNotExistException(String message) {
        super(message);
    }
}
