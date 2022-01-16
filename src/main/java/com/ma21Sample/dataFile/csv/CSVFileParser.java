package com.ma21Sample.dataFile.csv;

import com.ma21Sample.dataFile.DataFileParser;

import java.util.List;

public class CSVFileParser extends DataFileParser {
    public CSVFileParser(String srcFile) {
        super(srcFile);
    }

    @Override
    public List<String[]> parseDataFileToLists() {
        return null;
    }
}
