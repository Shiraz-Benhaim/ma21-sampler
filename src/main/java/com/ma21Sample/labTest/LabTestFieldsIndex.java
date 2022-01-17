package com.ma21Sample.labTest;

public enum LabTestFieldsIndex {
    ID_NUM(0),
    ID_TYPE(1),
    FIRST_NAME(2),
    LAST_NAME(3),
    RESULT_DATE(4),
    BIRTH_DATE(5),
    LAB_CODE(6),
    STICKER_NUMBER(7),
    RESULT_TEST_CORONA(8),
    VARIANT(9),
    TEST_TYPE(10);

    private final int index;

    LabTestFieldsIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }
}
