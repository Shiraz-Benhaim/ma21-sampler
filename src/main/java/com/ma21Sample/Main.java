package com.ma21Sample;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.dataFile.json.JsonFileWriter;
import com.ma21Sample.fileHandler.CreateDirectory;
import com.ma21Sample.labTest.LabTest;
import com.ma21Sample.labTest.LabTestsManager;
import com.ma21Sample.labTest.LabTestsManagerUtils;
import com.ma21Sample.madaReport.MadaReportsManager;
import com.ma21Sample.madaReport.MadaReportsManagerUtils;

public class Main {
    public static final String csvMadaReportsPath = "src\\main\\resources\\MadaReports.csv";
    public static final String jsonDir = "mada_reports\\";
    public static final String jsonFileName = "MadaReports.json";

    public static final String csvLabTestsPath = "src\\main\\resources\\LabTests.csv";

    public static void main(String[] args) {
        /*
        try {
            // Export
            MadaReportsManagerUtils managerUtils = new MadaReportsManagerUtils();
            DataFileParser csvFileParser = new CSVFileParser(csvMadaReportsPath);
            MadaReportsManager madaReportsManager = managerUtils.
                    listsToMadaReportsManager(csvFileParser.parseDataFileToLists());

            // Load
            CreateDirectory createDirectory = new CreateDirectory(jsonDir);
            createDirectory.createDirIfNotExisting();

            DataFileWriter jsonFileWriter = new JsonFileWriter(jsonDir + jsonFileName, madaReportsManager);
            jsonFileWriter.writeObjectToDataFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */

        // Part B
        try {
            // Export
            LabTestsManagerUtils utils = new LabTestsManagerUtils();
            DataFileParser csvFileParser = new CSVFileParser(csvLabTestsPath);
            LabTestsManager labTestsManager = utils.
                    listsToLabTestsManager(csvFileParser.parseDataFileToLists());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
