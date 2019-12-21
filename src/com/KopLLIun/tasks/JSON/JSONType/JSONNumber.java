package com.KopLLIun.tasks.JSON.JSONType;

import java.math.BigDecimal;

public class JSONNumber extends JSONValue {

    private BigDecimal number;

    public JSONNumber(BigDecimal number) {
        this.number = number;
    }

    public BigDecimal getNumber() {
        return number;
    }

    public void setNumber(BigDecimal number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return this.number.toString();
    }
}
