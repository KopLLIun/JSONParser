package com.KopLLIun.tasks.JSON.parser.impl;

import com.KopLLIun.tasks.JSON.JSONType.*;
import com.KopLLIun.tasks.JSON.parser.IJSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONParserImpl implements IJSONParser {

    //current position in recursion
    private int currentPosition;

    /**
     *
     * @param path path to file JSON
     * @return string of JSON file without spaces and \n
     */
    @Override
    public StringBuilder readJSONFromFile(String path) {
        StringBuilder json = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new FileReader(path))) {
                String s;
                while ((s = in.readLine()) != null) {
                    json.append(s.replaceAll("\\s+", ""));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     *
     * @param jsonText string of json without spaces and \n
     * @return list of string json text separated by comma
     * for example: string of json text - {"name":"John, "friends":["Alex", "Sam"]}
     * return {, "name", "John", "friends", [, "Alex", "Sam", ], }
     */
    @Override
    public List<String> getTokensFromJSON(StringBuilder jsonText) {
        List<String> tokens = new ArrayList<>();
        Pattern token = Pattern.compile("[\\[{}\\]]|\"[A-Za-z_0-9]+\"|[-]?\\d+(\\.\\d+)?[eE]?([-+]?\\d+)?|true|false|null");
        Matcher matcherTokens = token.matcher(jsonText);
        while (matcherTokens.find()) {
            tokens.add(matcherTokens.group());
        }
        return tokens;
    }

    /**
     *
     * @param jsonTokens jsonText
     * @param index current index in recursion
     * @return {@link JSONValue}
     */
    @Override
    public JSONValue getValue(List<String> jsonTokens, int index) {
        if (jsonTokens.get(currentPosition).equals("[")) {
            JSONArray array = new JSONArray();
            while (!jsonTokens.get(currentPosition + 1).equals("]")) {
                currentPosition++;
                array.addValue(getValue(jsonTokens, currentPosition));
            }
            currentPosition++;
            return array;
        } else if (jsonTokens.get(index).equals("{")) {
            JSONObject object = new JSONObject();
            while (!jsonTokens.get(currentPosition + 1).equals("}")) {
                currentPosition++;
                object.addObject(jsonTokens.get(currentPosition), getValue(jsonTokens, currentPosition++));
            }
            currentPosition++;
            return object;
        }

        //define type of token
        if (isNumber(jsonTokens.get(currentPosition))) {
            return new JSONNumber(new BigDecimal(jsonTokens.get(currentPosition)));
        } else if (isText(jsonTokens.get(currentPosition))) {
            return new JSONString(jsonTokens.get(currentPosition));
        } else if (isTrue(jsonTokens.get(currentPosition))) {
            return new JSONTrue();
        } else if (isFalse(jsonTokens.get(currentPosition))) {
            return new JSONFalse();
        } else if (isNull(jsonTokens.get(currentPosition))) {
            return new JSONNull();
        }
        return new JSONObject();
    }

    /**
     * check text for number
     * @param text string
     * @return if text is number - true else false
     */
    private boolean isNumber(String text) {
        return text.matches("[-]?\\d+(\\.\\d+)?[eE]?([-+]?\\d+)?");
    }

    /**
     * check text for text string
     * @param text string
     * @return if text is text string - true else false
     */
    private boolean isText(String text) {
        return text.matches("\"[A-Za-z_0-9]+\"");
    }

    /**
     * check text for true
     * @param text string
     * @return if text is true - true else false
     */
    private boolean isTrue(String text) {
        return text.matches("true");
    }

    /**
     * check text for false
     * @param text string
     * @return if text is false - true else false
     */
    private boolean isFalse(String text) {
        return text.matches("false");
    }

    /**
     * check text for bull
     * @param text string
     * @return if text is false - true else false
     */
    private boolean isNull(String text) {
        return text.matches("null");
    }
}
