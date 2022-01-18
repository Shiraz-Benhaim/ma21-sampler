package com.ma21Sample.labTest;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@JacksonXmlRootElement(localName = "labTests")
public class LabTestsManager {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "labTest")
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
