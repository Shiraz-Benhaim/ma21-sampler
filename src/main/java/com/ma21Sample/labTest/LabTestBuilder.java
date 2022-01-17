package com.ma21Sample.labTest;

import com.ma21Sample.fieldEnums.IdTypes;
import com.ma21Sample.fieldEnums.ResultsTypesTestCorona;
import com.ma21Sample.fieldEnums.TestTypes;
import lombok.Data;

@Data
public class LabTestBuilder {
    private int idNum;
    private IdTypes idType;
    private String firstName;
    private String lastName;
    private String resultDate;
    private String birthDate;
    private String labCode;
    private String stickerNumber;
    private ResultsTypesTestCorona resultTestCorona;
    private String variant;
    private TestTypes testType;

    private String joinDate = null;
    private Integer healthCareId = null;
    private String healthCareName = null;

    /*
    * Constructor for all the attributes except of the external attributes
    * */
    public LabTestBuilder(int idNum, IdTypes idType, String firstName, String lastName,
                          String resultDate, String birthDate, String labCode,
                          String stickerNumber, ResultsTypesTestCorona resultTestCorona,
                          String variant, TestTypes testType) {
        this.idNum = idNum;
        this.idType = idType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.resultDate = resultDate;
        this.birthDate = birthDate;
        this.labCode = labCode;
        this.stickerNumber = stickerNumber;
        this.resultTestCorona = resultTestCorona;
        this.variant = variant;
        this.testType = testType;
    }

    public LabTestBuilder withJoinDate(String date) {
        this.joinDate = date;
        return this;
    }

    public LabTestBuilder withHealthCareId(Integer healthCareId) {
        this.healthCareId = healthCareId;
        return this;
    }

    public LabTestBuilder withHealthCareName(String healthCareName) {
        this.healthCareName = healthCareName;
        return this;
    }

    public LabTest build() {
        // TODO: Calculate the values of the external fields
        return new LabTest(this);
    }
}
