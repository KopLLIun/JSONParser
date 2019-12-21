package com.KopLLIun.tasks.JSON.JSONType;

public class JSONString extends JSONValue{

    private String textValue;

    public JSONString() {
        this.textValue = null;
    }

    public JSONString(String textValue) {
        this.textValue = textValue;
    }

    public String getString() {
        return textValue;
    }

    public void setString(String string) {
        this.textValue = string;
    }

    @Override
    public String toString() {
        return this.textValue;
    }
}
