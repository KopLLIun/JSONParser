package com.KopLLIun.tasks.JSON.JSONType;

public class JSONTrue extends JSONValue {

    private boolean jsonTrue;

    public JSONTrue() {
        this.jsonTrue = true;
    }

    public JSONTrue(boolean jsonTrue) {
        this.jsonTrue = jsonTrue;
    }

    public boolean isJsonTrue() {
        return jsonTrue;
    }

    public void setJsonTrue(boolean jsonTrue) {
        this.jsonTrue = jsonTrue;
    }

    @Override
    public String toString() {
        return "true";
    }
}
