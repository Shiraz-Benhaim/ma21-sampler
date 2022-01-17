package com.ma21Sample.labTest;

import java.util.ArrayList;
import java.util.List;

public class LabTestsManager {
    private List<LabTest> results;

    public LabTestsManager() {
        this.results = new ArrayList<>();
    }

    public int numOfResults() {
        return this.results.size();
    }

    public void addLabTest(LabTest labTest) {
        this.results.add(labTest);
    }
}
