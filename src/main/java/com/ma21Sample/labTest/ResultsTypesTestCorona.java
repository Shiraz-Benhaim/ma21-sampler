package com.ma21Sample.labTest;

public enum ResultsTypesTestCorona {
    NEGATIVE(0),
    POSITIVE(1),
    BORDERLINE(2),
    UNTESTED(3);

    private int result;

    ResultsTypesTestCorona(int result) {
        this.result = result;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
