package com.KopLLIun.tasks.JSON;

import com.KopLLIun.tasks.JSON.JSONType.*;
import com.KopLLIun.tasks.JSON.parser.impl.JSONParserImpl;

public class Main {
    public static void main(String[] args) {

        //String path = "D:\\json_example.json";
        JSONParserImpl jsonParser = new JSONParserImpl();

        //StringBuilder simpleJson = new StringBuilder("[1]");
        StringBuilder jsonArray = new StringBuilder("{\"array\":[1,[2,[3, \"text\", true], false, null],[4]]}");
        //StringBuilder jsonObjectText = new StringBuilder("{\"name:\"1, \"array:\"[1, 2, 3], \"numbers:\"[1,[2,[3, \"text\", true]],[4]]}");
        StringBuilder bigJsonObject = new StringBuilder("{\"number\":1,\"ARRAY\":[1,2,3, null,\"text\",[1,2,3,\"text\"],{}],\"array\":[1,2,3,\"text\"],\"object\":{}}");

        JSONValue jsonObject = jsonParser.getValue(jsonParser.getTokensFromJSON(jsonArray), 0);
        System.out.println(jsonObject);
    }
}
