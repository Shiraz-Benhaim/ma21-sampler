package com.ma21Sample.labTest;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
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
