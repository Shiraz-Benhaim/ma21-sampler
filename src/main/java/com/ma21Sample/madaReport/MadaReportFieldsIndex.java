package com.ma21Sample.madaReport;

public enum MadaReportFieldsIndex {
    MDA_CODE(0),
    ID_NUM(1),
    ID_TYPE(2),
    FIRST_NAME(3),
    LAST_NAME(4),
    CITY(5),
    STREET(6),
    BUILDING_NUMBER(7),
    BAR_CODE(8),
    GET_DATE(9),
    TAKE_DATE(10),
    RESULT_DATE(11);

    private final int index;

    MadaReportFieldsIndex(int index) {
        this.index = index;
    }

    public int getIndex() { return this.index; }
}
