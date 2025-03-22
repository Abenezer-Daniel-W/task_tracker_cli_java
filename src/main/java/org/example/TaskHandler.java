package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class TaskHandler {
    private final String dbFileName = "data/data.json";
    private JSONObject jsonObject;
    private JSONParser parser;
    public TreeMap<Integer, String> taksIdMap;



    public TaskHandler() throws IOException, ParseException {
        parser = new JSONParser();

        FileReader reader = new FileReader(dbFileName);

        JSONParser parser = new JSONParser();
        jsonObject = (JSONObject) parser.parse(reader);
        reader.close();

        taksIdMap = JsonToMap();
    }

    public String addTask(String taskName){
        if (taskName  == null || taskName.isEmpty())
            throw new IllegalArgumentException("takName is null or empty.");
        int nextId = taksIdMap.lastKey()+1;
        taksIdMap.put(nextId, taskName);


        return  "Task (ID:"+nextId+") added Successfully.";

    }

    public String removeTask(int id){
        if(!taksIdMap.containsKey(id)){
            throw new NoSuchElementException("task Id not found.");
        }
        taksIdMap.remove(id);
        return  "Task (ID:"+id+") removed Successfully.";
    }


    public String listTask(){
        return taksIdMap.toString();
    }

    public TreeMap<Integer, String> JsonToMap(){
        ArrayList<String> keys = new ArrayList<>();
        for(Object s: jsonObject.keySet()){
            keys.add((String) s);
        }

        ArrayList<String> values = new ArrayList<>();
        for(Object s: jsonObject.values()){
            values.add((String) s);
        }

        TreeMap<Integer, String> res = new TreeMap<>();
        for(int i =0; i<keys.size(); i++){
            res.put(Integer.parseInt(keys.get(i)), values.get(i));
        }

        return res;
    }
    public void writeOut() throws IOException {
        FileWriter writer = new FileWriter(dbFileName);
        JSONObject resJsonObject = new JSONObject();
        for (Integer i : taksIdMap.keySet()){
            resJsonObject.put(i, taksIdMap.get(i));
        }
        writer.write(resJsonObject.toJSONString());
        writer.flush();
    }
}
