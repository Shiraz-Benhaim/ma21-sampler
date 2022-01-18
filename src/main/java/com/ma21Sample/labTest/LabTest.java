package com.ma21Sample.labTest;

import com.ma21Sample.fieldEnums.ResultsTypesTestCorona;
import com.ma21Sample.fieldEnums.IdTypes;
import com.ma21Sample.fieldEnums.TestTypes;
import lombok.Data;

@Data
public class LabTest {
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

    // External
    private String joinDate;
    private Integer healthCareId;
    private String healthCareName;

    // Getters to the numeric enums
    public Integer getIdType() {
        return this.idType.getType();
    }
    
    public Integer getResultTestCorona() {
        return this.resultTestCorona.getResult();
    }

    /*
    * Constructor to the builder of this class
    * */
    public LabTest(LabTestBuilder labTestBuilder) {
        this.idNum = labTestBuilder.getIdNum();
        this.idType = labTestBuilder.getIdType();
        this.firstName = labTestBuilder.getFirstName();
        this.lastName = labTestBuilder.getLastName();
        this.resultDate = labTestBuilder.getResultDate();
        this.birthDate = labTestBuilder.getBirthDate();
        this.labCode = labTestBuilder.getLabCode();
        this.stickerNumber = labTestBuilder.getStickerNumber();
        this.resultTestCorona = labTestBuilder.getResultTestCorona();
        this.variant = labTestBuilder.getVariant();
        this.testType = labTestBuilder.getTestType();
        this.joinDate = labTestBuilder.getJoinDate();
        this.healthCareId = labTestBuilder.getHealthCareId();
        this.healthCareName = labTestBuilder.getHealthCareName();
    }
}
