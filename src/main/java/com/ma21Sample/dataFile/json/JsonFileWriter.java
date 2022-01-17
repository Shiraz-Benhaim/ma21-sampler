package com.ma21Sample.dataFile.json;

import com.ma21Sample.dataFile.DataFileWriter;

import java.util.List;

public class JsonFileWriter extends DataFileWriter {
    public JsonFileWriter(String dstFile) {
        super(dstFile);
    }

    @Override
    public List<String[]> writeObjectToDataFile() {
        return null;
    }
}
