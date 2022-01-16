package com.ma21Sample.madaReport;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MadaReport {
    private String MDACODE;
    private String IDNum;
    private String IDType;
    private String FirstName;
    private String LastName;
    private String City;
    private String Street;
    private String BuildingNumber;
    private String Barcode;
    private String GetDate;
    private String TakeDate;
    private String ResultDate;
}
