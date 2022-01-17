package com.ma21Sample.madaReport;

import com.ma21Sample.fieldEnums.IdTypes;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MadaReport {
    private String MDACODE;
    private Integer IDNum;
    private IdTypes IDType;
    private String FirstName;
    private String LastName;
    private String City;
    private String Street;
    private Integer BuildingNumber;
    private String Barcode;
    private String GetDate;
    private String TakeDate;
    private String ResultDate;
}
