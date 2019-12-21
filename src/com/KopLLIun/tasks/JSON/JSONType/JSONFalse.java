package com.KopLLIun.tasks.JSON.JSONType;

public class JSONFalse extends JSONValue {

    private boolean jsonFalse;

    public JSONFalse() {
        this.jsonFalse = false;
    }

    public JSONFalse(boolean jsonFalse) {
        this.jsonFalse = jsonFalse;
    }

    public boolean isJsonFalse() {
        return jsonFalse;
    }

    public void setJsonFalse(boolean jsonFalse) {
        this.jsonFalse = jsonFalse;
    }

    @Override
    public String toString() {
        return "false";
    }
}
