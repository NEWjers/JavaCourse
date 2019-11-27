package com.company;

import java.io.*;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class ReadWriteJson {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public void writeInFile(String file, String json) throws IOException {
        FileWriter writer = new FileWriter(file);
        writer.write(json);
        writer.flush();
        writer.close();
    }


    public String readFromFile(String file) throws IOException {
        String json = "";
        FileReader reader = new FileReader(file);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()){
            json += scanner.nextLine();
        }
        reader.close();
        return json;
    }


    public String convertToJson(Enrollee enrollee) {
        String json = GSON.toJson(enrollee);
        return json;
    }


    public Enrollee convertToEnrolle(String json) {
        return GSON.fromJson(json,Enrollee.class);
    }


}
