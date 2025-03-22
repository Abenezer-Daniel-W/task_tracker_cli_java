package org.example;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class Main {
    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.print("Please pass in a command");
//        }
//
//        if (args[0].equals("add")) {
//
//        } else if (args[0].equals("list")) {
//
//        }
        JsonHandler jsonHandler;
        try {
            jsonHandler = new JsonHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("hey");
        System.out.print(jsonHandler.listTask());



    }



}