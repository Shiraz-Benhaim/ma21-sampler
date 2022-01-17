package com.ma21Sample.dataFile;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class DataFileWriter {
    protected String dstFile;

    public abstract void writeObjectToDataFile();
}
