package com.ma21Sample.dataFile.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.exceptions.FailedToWriteDataFileException;
import com.ma21Sample.madaReport.MadaReportsManager;
import com.ma21Sample.madaReport.MadaReportsManagerUtils;
import org.apache.log4j.Logger;

import java.io.File;

public class JsonFileWriter extends DataFileWriter {
    final int MAX_RECORDS_IN_JSON_FILE = 50000;

    private MadaReportsManager reportsManager;

    public JsonFileWriter(String dstFile, MadaReportsManager madaReportsManager) {
        super(Logger.getLogger(JsonFileWriter.class), dstFile);
        this.reportsManager = madaReportsManager;
    }

    public MadaReportsManager getMadaReportsManager() {
        return reportsManager;
    }

    public void setMadaReportsManager(MadaReportsManager reportsManager) {
        this.reportsManager = reportsManager;
    }

    @Override
    public void writeObjectToDataFile() throws FailedToWriteDataFileException {
        ObjectMapper objectMapper = new ObjectMapper();
        MadaReportsManagerUtils reportsManagerUtils = new MadaReportsManagerUtils();
        MadaReportsManager[] madaReportsManagers;
        String currPathName;

        try {
            madaReportsManagers = reportsManagerUtils
                    .splitMadaReportsManager(this.reportsManager, MAX_RECORDS_IN_JSON_FILE);

            for (int i = 0; i < madaReportsManagers.length; i++) {
                // If there would be only one file, it is not necessary to add a serial number
                currPathName = madaReportsManagers.length == 1 ? super.dstFile :
                        super.dstFile.substring(0, super.dstFile.lastIndexOf(".")) + (i + 1) + ".json";
                objectMapper.writeValue(new File(currPathName), madaReportsManagers[i]);
            }
            super.logger.info("The information was written to the json file successfully");
        } catch (Exception e) {
            super.logger.error("The information was not written to the json file");
            throw new FailedToWriteDataFileException(e.getMessage(), e.getCause());
        }
    }
}
