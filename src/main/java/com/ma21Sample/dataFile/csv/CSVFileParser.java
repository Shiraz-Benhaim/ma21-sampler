package com.ma21Sample.dataFile.csv;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.fileHandler.ReadFileContent;
import com.ma21Sample.utils.StringSplitter;

import java.io.IOException;
import java.util.List;

public class CSVFileParser extends DataFileParser {
    public CSVFileParser(String srcFile) {
        super(srcFile);
    }

    @Override
    public List<String[]> parseDataFileToLists() {
        List<String[]> data = null;
        StringSplitter stringSplitter = new StringSplitter();

        try {
            ReadFileContent readFileContent = new ReadFileContent(super.srcFile);
            data = stringSplitter.splitStringInCsvFormat(readFileContent.readContent());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
}
