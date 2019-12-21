package com.KopLLIun.tasks.JSON.JSONType;
import java.util.HashMap;
import java.util.Map;

public class JSONObject extends JSONValue {

    private Map<String, JSONValue> pairs;

    public JSONObject() {
        this.pairs = new HashMap<>();
    }

    public JSONObject(Map<String, JSONValue> pairs) {
        this.pairs = pairs;
    }

    public void addObject(String key, JSONValue jsonValue) {
        this.pairs.put(key, jsonValue);
    }

    public Map<String, JSONValue> getPairs() {
        return this.pairs;
    }

    public void setPairs(Map<String, JSONValue> pairs) {
        this.pairs = pairs;
    }

    @Override
    public String toString() {
        StringBuilder map = new StringBuilder("{");
        if (!this.pairs.isEmpty()) {
            for (Map.Entry<String, JSONValue> pair : this.pairs.entrySet()) {
                String key = pair.getKey();
                Object value = pair.getValue();
                map.append(key).append(":").append(value).append(",");
            }
            return map.delete(map.length() - 1, map.length()).toString() + "}";
            //return list.delete(list.length() - 1, list.length()).toString() + "]";
        }
        return "{}";
    }
}
