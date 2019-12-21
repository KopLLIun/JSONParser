package com.KopLLIun.tasks.JSON.parser;

import com.KopLLIun.tasks.JSON.JSONType.JSONValue;
import java.util.List;

public interface IJSONParser {
    StringBuilder readJSONFromFile(String path);
    List<String> getTokensFromJSON(StringBuilder jsonText);
    JSONValue getValue(List<String> jsonTokens, int index);
}
