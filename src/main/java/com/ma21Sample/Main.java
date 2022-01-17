package com.ma21Sample;

import com.ma21Sample.dataFile.DataFileParser;
import com.ma21Sample.dataFile.csv.CSVFileParser;
import com.ma21Sample.madaReport.MadaReport;
import com.ma21Sample.madaReport.MadaReportsManager;
import com.ma21Sample.madaReport.MadaReportsManagerUtils;

public class Main {
    public static final String csvPath = "src\\main\\resources\\MadaReports.csv";
    public static final String jsonPath = "mada_reports\\MadaReports.json";

    public static void main(String[] args) {
        MadaReportsManagerUtils managerUtils = new MadaReportsManagerUtils();
        DataFileParser csvFileParser = new CSVFileParser(csvPath);
        MadaReportsManager madaReportsManager = managerUtils.
                listsToMadaReportsManager(csvFileParser.parseDataFileToLists());

        for (MadaReport report : madaReportsManager.getReports()) {
            System.out.println(report.getFirstName() + " " + report.getLastName()
            + " Type: " + report.getIDType().name());
        }
    }
}
