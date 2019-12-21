package com.KopLLIun.tasks.JSON.JSONType;

public class JSONNull extends JSONValue {

    private Object jsonNull;

    public JSONNull() {
        this.jsonNull = null;
    }

    public JSONNull(Object jsonNull) {
        this.jsonNull = jsonNull;
    }

    public Object getJsonNull() {
        return jsonNull;
    }

    public void setJsonNull(String jsonNull) {
        this.jsonNull = jsonNull;
    }

    @Override
    public String toString() {
        return "null";
    }
}
