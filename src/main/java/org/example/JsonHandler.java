package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonHandler {
    private final String dbFileName = "taskData/data.json";
    public JSONObject jsonObject;
    private JSONParser parser;



    public  JsonHandler() throws IOException, ParseException {
        parser = new JSONParser();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(dbFileName);
        if (inputStream == null) {
            throw new FileNotFoundException("Resource not found: " + dbFileName);
        }


        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(new InputStreamReader(inputStream));
        inputStream.close();
    }

    public void addTask(){
    }
    public String listTask(){
        return jsonObject.toJSONString();
    }
}
