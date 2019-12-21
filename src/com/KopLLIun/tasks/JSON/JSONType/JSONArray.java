package com.KopLLIun.tasks.JSON.JSONType;

import java.util.ArrayList;
import java.util.List;

public class JSONArray extends JSONValue {

    private List<JSONValue> array;

    public JSONArray() {
        this.array = new ArrayList<>();
    }

    public JSONArray(List<JSONValue> value) {
        this.array = value;
    }

    public void addValue(JSONValue jsonValue) {
        this.array.add(jsonValue);
    }

    public void setJSONArray(List<JSONValue> array) {
        this.array = array;
    }

    public List<JSONValue> getJSONArray() {
        return this.array;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("[");
        if (!this.array.isEmpty()) {
            for (JSONValue value : array) {
                list.append(value).append(",");
            }
            return list.delete(list.length() - 1, list.length()).toString() + "]";
        }
        return "[]";
    }
}
