package com.ma21Sample.dataFile;

import com.ma21Sample.exceptions.FailedToWriteDataFileException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.log4j.Logger;

@Data
@AllArgsConstructor
public abstract class DataFileWriter {
    protected final Logger logger;
    protected String dstFile;

    public abstract void writeObjectToDataFile() throws FailedToWriteDataFileException;
}
