package com.ma21Sample;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.dataFile.DataFileWriter;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.dataFile.json.JsonFileWriter;
import com.ma21Sample.dataFile.xml.XmlFileWriter;
import com.ma21Sample.fileHandler.CreateDirectory;
import com.ma21Sample.labTest.LabTest;
import com.ma21Sample.labTest.LabTestsManager;
import com.ma21Sample.labTest.LabTestsManagerUtils;
import com.ma21Sample.madaReport.MadaReportsManager;
import com.ma21Sample.madaReport.MadaReportsManagerUtils;
import org.apache.log4j.Logger;

public class Main {
    public static final String csvMadaReportsPath = "src\\main\\resources\\MadaReports.csv";
    public static final String jsonDir = "mada_reports\\";
    public static final String jsonFileName = "MadaReports.json";

    public static final String csvLabTestsPath = "src\\main\\resources\\LabTests.csv";
    public static final String xmlDir = "LABTESTS\\";
    public static final String xmlFileName = "lab_tests.xml";

    public static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        logger.debug("Program Started");

        // Part A
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

            // Load
            CreateDirectory createDirectory = new CreateDirectory(xmlDir);
            createDirectory.createDirIfNotExisting();

            DataFileWriter xmlFileWriter = new XmlFileWriter(xmlDir + xmlFileName, labTestsManager);
            xmlFileWriter.writeObjectToDataFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
