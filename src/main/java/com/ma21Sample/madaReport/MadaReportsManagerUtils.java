package com.ma21Sample.madaReport;

import com.ma21Sample.exceptions.FailedToParseDataFileException;

import java.util.List;

public class MadaReportsManagerUtils {
    /*
     * Function convert a list of strings with the information about the
     *  reports to a list of reports (MadaReportsManager)
     * reportsData - the list with the information about the reports
     * returns a list of reports with ths information
     * */
    public MadaReportsManager listsToMadaReportsManager(List<String[]> reportsData) throws FailedToParseDataFileException {
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
            throw new FailedToParseDataFileException(e.getMessage(), e.getCause());
        }

        return reportsManager;
    }

    /*
     * Function split a list of mada's reports to sub lists
     * cars - the list of all reports
     * reportsInEachList - the number of reports in each of the new sub lists
     * returns list of lists of reports
     * */
    public MadaReportsManager[] splitMadaReportsManager(MadaReportsManager reports, Integer reportsInEachList) {
        int numOfSplits = reports.numOfReports() / reportsInEachList +
                (reports.numOfReports() % reportsInEachList == 0 ? 0 : 1); // for the rest
        MadaReportsManager[] subReportsManagers = new MadaReportsManager[numOfSplits];
        int currEnd;

        for (int i = 0; i < numOfSplits; i++) {
            currEnd = (i + 1) * reportsInEachList;
            if (currEnd >= reports.numOfReports()) {
                currEnd = reports.numOfReports() - 1;
            }
            subReportsManagers[i] = new MadaReportsManager(
                    reports.getReports().subList(i * reportsInEachList, currEnd)
            );
        }

        return subReportsManagers;
    }
}
