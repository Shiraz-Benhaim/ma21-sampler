package com.ma21Sample.labTest;

import com.ma21Sample.exceptions.FailedToParseDataFileException;
import com.ma21Sample.madaReport.IdTypes;

import java.util.List;

public class LabTestsManagerUtils {
    /*
     * Function convert a list of strings with the information about the
     *  test results to a list of results (LabTestsManager)
     * resultsData - the list with the information about the results
     * returns a list of results with ths information
     * */
    public LabTestsManager listsToLabTestsManager(List<String[]> resultsData) throws FailedToParseDataFileException {
        LabTestsManager labTestsManager = new LabTestsManager();

        try {
            for (String[] record : resultsData) {
                labTestsManager.addLabTest(new LabTest(
                        Integer.parseInt(record[LabTestFieldsIndex.ID_NUM.getIndex()]),
                        IdTypes.values()[Integer.parseInt(record[LabTestFieldsIndex.ID_TYPE.getIndex()])],
                        record[LabTestFieldsIndex.FIRST_NAME.getIndex()],
                        record[LabTestFieldsIndex.LAST_NAME.getIndex()],
                        record[LabTestFieldsIndex.RESULT_DATE.getIndex()],
                        record[LabTestFieldsIndex.BIRTH_DATE.getIndex()],
                        record[LabTestFieldsIndex.LAB_CODE.getIndex()],
                        record[LabTestFieldsIndex.STICKER_NUMBER.getIndex()],
                        ResultsTypesTestCorona.values()[Integer.
                                parseInt(record[LabTestFieldsIndex.RESULT_TEST_CORONA.getIndex()])],
                        record[LabTestFieldsIndex.VARIANT.getIndex()],
                        TestTypes.valueOf(record[LabTestFieldsIndex.TEST_TYPE.getIndex()])
                ));
            }
        } catch (Exception e) {
            throw new FailedToParseDataFileException(e.getMessage(), e.getCause());
        }

        return labTestsManager;
    }
}
