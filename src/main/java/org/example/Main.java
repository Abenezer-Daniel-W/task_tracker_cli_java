package org.example;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {





        TaskHandler taskHandler;

        taskHandler = new TaskHandler();
        


        if (args.length == 0) {
            System.out.print("Please pass in a command");
        }

        if (args[0].equals("add") && args.length >= 2) {
            System.out.println(taskHandler.addTask(args[1]));
        } else if (args[0].equals("list")) {
            System.out.println("Task List:");
            System.out.println("--------------------");
            System.out.println(taskHandler.listTask());
        } else if (args[0].equals("delete") && args.length >=2) {
            taskHandler.removeTask(args[1]);
        }
        else if (args[0].equals("update") && args.length >=3) {
            taskHandler.updateTask(args[1],args[2]);
        } else if (args[0].equals("mark-in-progress") && args.length>=2) {
            taskHandler.inProgressTask(args[1]);
        }else if (args[0].equals("mark-done") && args.length>=2){
            taskHandler.doneTask(args[1]);
        }


        try {
            taskHandler.writeOut();
        }catch (IOException e){
            System.out.println("can't writ out file");
        }





    }



}