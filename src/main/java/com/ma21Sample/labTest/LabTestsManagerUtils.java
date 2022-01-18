package com.ma21Sample.labTest;

import com.ma21Sample.exceptions.FailedToParseDataFileException;
import com.ma21Sample.fieldEnums.IdTypes;
import com.ma21Sample.fieldEnums.ResultsTypesTestCorona;
import com.ma21Sample.fieldEnums.TestTypes;
import health_care_provider.errors.InvalidIdException;
import org.apache.log4j.Logger;

import java.util.List;

public class LabTestsManagerUtils {
    private final Logger logger = Logger.getLogger(LabTestsManagerUtils.class);

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
                try {
                    labTestsManager.addLabTest(new LabTestBuilder(
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
                    ).build());
                    this.logger.debug("The information was successfully converted to LabTests list");
                } catch (InvalidIdException e) {
                    this.logger.warn("The id " + Integer.parseInt(record[LabTestFieldsIndex.ID_NUM.getIndex()])
                            + " is not valid. The test will not be added to the data file");
                }
            }
        } catch (Exception e) {
            this.logger.error("Bad syntax of lab tests records");
            throw new FailedToParseDataFileException(e.getMessage(), e.getCause());
        }

        return labTestsManager;
    }

    /*
     * Function split a list of lab tests results to sub lists
     * cars - the list of all results
     * resultsInEachList - the number of results in each of the new sub lists
     * returns list of lists of results
     * */
    public LabTestsManager[] splitLabTestsManager(LabTestsManager results, Integer resultsInEachList) {
        int numOfSplits = results.numOfResults() / resultsInEachList +
                (results.numOfResults() % resultsInEachList == 0 ? 0 : 1); // for the rest
        LabTestsManager[] subResultsManagers = new LabTestsManager[numOfSplits];
        int currEnd;

        for (int i = 0; i < numOfSplits; i++) {
            currEnd = (i + 1) * resultsInEachList;
            if (currEnd >= results.numOfResults()) {
                currEnd = results.numOfResults() - 1;
            }
            subResultsManagers[i] = new LabTestsManager(
                    results.getResults().subList(i * resultsInEachList, currEnd)
            );
        }

        return subResultsManagers;
    }
}
