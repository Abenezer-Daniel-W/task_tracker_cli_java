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
    private int nexID = 0;


    public TaskHandler() {
        parser = new JSONParser();

        try (FileReader reader = new FileReader(dbFileName)) {
            Object parsed = parser.parse(reader);

            if (!(parsed instanceof JSONObject)) {
                System.out.println("Error: The JSON structure is not a valid object.");
                jsonObject = new JSONObject(); // Initialize to empty to avoid null issues
                return;
            }

            jsonObject = (JSONObject) parsed;

            for (Object key : jsonObject.keySet()) {
                try {
                    nexID = Math.max(nexID, Integer.parseInt((String) key));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid key found (not an integer): \"" + key + "\". Skipping this key.");
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Warning: Database file \"" + dbFileName + "\" not found.");
            jsonObject = new JSONObject();
        } catch (IOException e) {
            System.out.println("Error reading file \"" + dbFileName + "\": " + e.getMessage());
            jsonObject = new JSONObject();
        } catch (ParseException e) {
            System.out.println("Error: Failed to parse JSON from file \"" + dbFileName + "\". The file may be empty or malformed.");
            jsonObject = new JSONObject();
        }
    }


    public String listTask() {
        HashMap<String, JSONObject> map = jsonObjectToMap(jsonObject);
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : map.keySet()) {
            JSONObject value = map.get(key);

            // Safely get the fields from the JSONObject
            String description = (String) value.getOrDefault("description", "No description");
            String status = (String) value.getOrDefault("status", "No status");

            stringBuilder.append("Task ").append(key).append(":\n")
                    .append("  Description: ").append(description).append("\n")
                    .append("  Status: ").append(status).append("\n\n");
        }

        return stringBuilder.toString();
    }


    @SuppressWarnings("unchecked")
    public String addTask(String description){
        JSONObject detail = new JSONObject();
        detail.put("description", description);
        detail.put("status", "none");
        nexID++;
        jsonObject.put(Integer.toString(nexID), detail);
        return  "Output: Task added successfully (ID: "+nexID+")";
    }


    public void removeTask(String id){
        jsonObject.remove(id);
    }


    @SuppressWarnings("unchecked")
    public void updateTask(String id,String newDescription){
        JSONObject prev = (JSONObject) jsonObject.get(id);
        prev.put("description", newDescription);
    }

    @SuppressWarnings("unchecked")
    public void inProgressTask(String id){
        JSONObject prev = (JSONObject) jsonObject.get(id);
        prev.put("status", "In progress");
    }

    @SuppressWarnings("unchecked")
    public void doneTask(String id){
        JSONObject prev = (JSONObject) jsonObject.get(id);
        prev.put("status", "Done");
    }


    public void writeOut() throws IOException {
        FileWriter write = new FileWriter(dbFileName);
        write.write(jsonObject.toJSONString());
        write.flush();
        write.close();
    }

    private HashMap<String, JSONObject> jsonObjectToMap(JSONObject obj) {
        HashMap<String, JSONObject> res = new HashMap<>();
        for(Object k: obj.keySet()){
            res.put((String) k, (JSONObject) jsonObject.get(k));
        }
        return res;
    }
}
