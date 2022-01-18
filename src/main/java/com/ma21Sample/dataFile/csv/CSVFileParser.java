package com.ma21Sample.dataFile.csv;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.exceptions.CSVFileNotExistException;
import com.ma21Sample.exceptions.FailedToParseDataFileException;
import com.ma21Sample.fileHandler.ReadFileContent;
import com.ma21Sample.utils.StringSplitter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class CSVFileParser extends DataFileParser {
    public CSVFileParser(String srcFile) {
        super(Logger.getLogger(CSVFileParser.class), srcFile);
    }

    @Override
    public List<String[]> parseDataFileToLists() throws CSVFileNotExistException, FailedToParseDataFileException {
        List<String[]> data = null;
        StringSplitter stringSplitter = new StringSplitter();

        try {
            ReadFileContent readFileContent = new ReadFileContent(super.srcFile);
            data = stringSplitter.splitStringInCsvFormat(readFileContent.readContent());
            logger.info("the csv file extract successfully");
        } catch (IOException e) {
            super.logger.error("CSV file not found");
            throw new CSVFileNotExistException(e.getMessage());
        } catch (Exception e) {
            super.logger.error("Bad syntax of csv file");
            throw new FailedToParseDataFileException(e.getMessage(), e.getCause());
        }

        return data;
    }
}
