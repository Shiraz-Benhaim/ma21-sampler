package com.ma21Sample.labTest;

import com.ma21Sample.madaReport.IdTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LabTest {
    private int idNum;
    private IdTypes idType;
    private String firstName;
    private String lastName;
    private String resultDate;
    private String birthDate;
    private String labCode;
    private String stickerNumber;
    private Integer resultTestCorona;
    private String variant;
    private String testType;
}
