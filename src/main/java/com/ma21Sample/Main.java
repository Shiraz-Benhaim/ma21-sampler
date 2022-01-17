package com.ma21Sample;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.dataFile.json.JsonFileWriter;
import com.ma21Sample.fileHandler.CreateDirectory;
import com.ma21Sample.madaReport.MadaReport;
import com.ma21Sample.madaReport.MadaReportsManager;
import com.ma21Sample.madaReport.MadaReportsManagerUtils;

public class Main {
    public static final String csvPath = "src\\main\\resources\\MadaReports.csv";
    public static final String jsonDir = "mada_reports\\";
    public static final String jsonFileName = "MadaReports.json";

    public static void main(String[] args) {
        // Export
        MadaReportsManagerUtils managerUtils = new MadaReportsManagerUtils();
        DataFileParser csvFileParser = new CSVFileParser(csvPath);
        MadaReportsManager madaReportsManager = managerUtils.
                listsToMadaReportsManager(csvFileParser.parseDataFileToLists());

        // Load
        CreateDirectory createDirectory = new CreateDirectory(jsonDir);
        createDirectory.createDirIfNotExisting();

        DataFileWriter jsonFileWriter = new JsonFileWriter(jsonDir + jsonFileName, madaReportsManager);
        jsonFileWriter.writeObjectToDataFile();
    }
}
