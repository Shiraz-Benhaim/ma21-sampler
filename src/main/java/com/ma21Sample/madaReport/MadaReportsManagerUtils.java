package com.ma21Sample.madaReport;

import java.util.List;

public class MadaReportsManagerUtils {
    /*
     * Function convert a list of strings with the information about the
     *  reports to a list of reports (MadaReportsManager)
     * reportsData - the list with the information about the reports
     * returns a list of reports with ths information
     * */
    public MadaReportsManager listsToMadaReportsManager (List<String[]> reportsData) {
        MadaReportsManager reportsManager = new MadaReportsManager();

        try {
            for (String[] record : reportsData) {
                reportsManager.addMadaReport(new MadaReport(
                    record[MadaReportFieldsIndex.MDA_CODE.getIndex()],
                    Integer.parseInt(record[MadaReportFieldsIndex.ID_NUM.getIndex()]),
                    IdTypes.values()[Integer.parseInt(record[MadaReportFieldsIndex.ID_TYPE.getIndex()])],
                    record[MadaReportFieldsIndex.FIRST_NAME.getIndex()],
                    record[MadaReportFieldsIndex.LAST_NAME.getIndex()],
                    record[MadaReportFieldsIndex.CITY.getIndex()],
                    record[MadaReportFieldsIndex.STREET.getIndex()],
                    Integer.parseInt(record[MadaReportFieldsIndex.BUILDING_NUMBER.getIndex()]),
                    record[MadaReportFieldsIndex.BARCODE.getIndex()],
                    record[MadaReportFieldsIndex.GET_DATE.getIndex()],
                    record[MadaReportFieldsIndex.TAKE_DATE.getIndex()],
                    record[MadaReportFieldsIndex.RESULT_DATE.getIndex()]
                ));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return reportsManager;
    }
}
