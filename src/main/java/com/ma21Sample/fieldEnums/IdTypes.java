package com.ma21Sample.fieldEnums;

public enum IdTypes {
    ISRAELI_ID(0),
    PASSPORT(1),
    HMO_NUMBER(2);

    private int type;

    IdTypes(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
