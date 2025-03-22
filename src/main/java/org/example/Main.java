package org.example;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {





        TaskHandler taskHandler;
        try {
            taskHandler = new TaskHandler();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }






        if (args.length == 0) {
            System.out.print("Please pass in a command");
        }

        if (args[0].equals("add") && args.length >= 2) {
            taskHandler.addTask(args[1]);
        } else if (args[0].equals("list")) {
            System.out.println(taskHandler.listTask());
        }


        try {
            taskHandler.writeOut();
        }catch (IOException e){
            System.out.println("can't writ out file");
        }





    }



}