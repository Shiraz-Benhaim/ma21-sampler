package com.ma21Sample.labTest.filter;

import com.ma21Sample.fieldEnums.ResultsTypesTestCorona;
import com.ma21Sample.labTest.LabTest;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaPositive implements CriteriaLabTests {
    @Override
    public List<LabTest> criteria(List<LabTest> tests) {
        return tests.stream()
                .filter(result -> ResultsTypesTestCorona.values()[result.getResultTestCorona()]
                        .equals(ResultsTypesTestCorona.POSITIVE))
                .collect(Collectors.toList());
    }
}
