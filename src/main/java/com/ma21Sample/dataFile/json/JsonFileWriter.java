package com.ma21Sample.dataFile.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.madaReport.MadaReportsManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonFileWriter extends DataFileWriter {
    private MadaReportsManager reportsManager;

    public JsonFileWriter(String dstFile, MadaReportsManager madaReportsManager) {
        super(dstFile);
        this.reportsManager = madaReportsManager;
    }

    public MadaReportsManager getMadaReportsManager() {
        return reportsManager;
    }

    public void setMadaReportsManager(MadaReportsManager reportsManager) {
        this.reportsManager = reportsManager;
    }

    @Override
    public void writeObjectToDataFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(super.dstFile), this.reportsManager);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
