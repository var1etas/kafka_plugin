package com.example.demo.kafka_plugin.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class JsonSaver {
    public void save(Map<String, String> jsonString){
        File folder = new File(jsonString.get("directory"));
        if (!folder.exists()) {
            folder.mkdir();
        }
        jsonString.remove("directory");
        try (Writer writer = new FileWriter(folder +"/" + jsonString.get("topics") + ".json", true)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(jsonString, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
