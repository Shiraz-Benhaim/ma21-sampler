package com.ma21Sample.dataFile;

import com.ma21Sample.exceptions.FailedToParseDataFileException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.List;

@Data
@AllArgsConstructor
public abstract class DataFileParser {
    protected final Logger logger;
    protected String srcFile;

    public abstract List<String[]> parseDataFileToLists() throws FileNotFoundException, FailedToParseDataFileException;
}
