package com.example.demo.kafka_plugin.service;

import com.example.demo.kafka_plugin.dto.HeadersDTO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageConverter {
    JSONParser parser = new JSONParser();
    public ProducerRecord<String,String> read(File dir) {
        try (FileReader reader = new FileReader(dir)){
            JSONObject jsonMessage = (JSONObject) parser.parse(reader);

            List<Header> headersList = new ArrayList<>();
            JSONArray headersJsonArray = (JSONArray) jsonMessage.get("headers");
            for(Object head: headersJsonArray){
                JSONObject headObject = (JSONObject) head;
                String key = (String) headObject.get("key");
                String value = (String) headObject.get("value");
                headersList.add(new RecordHeader(key,value.getBytes()));
            }

            return new ProducerRecord<>((String)jsonMessage.get("topic"), null,"message", (String) jsonMessage.get("message"), headersList);

        } catch (Exception e){
            System.out.println("Read exception: " + e);
        }
        return null;
    }

    public void save(Map<String, String> jsonMap){
        File folder = new File(jsonMap.get("directory"));
        if (!folder.exists()) {
            folder.mkdir();
        }
        jsonMap.remove("directory");

        Map<String, Object> jsonKafkaMessage = new HashMap<>();
        List<HeadersDTO> headerList = new ArrayList<>();
        String headers = jsonMap.get("headers");
        while (headers.contains(":")){
            if(headers.contains(";")) {
                headerList.add(new HeadersDTO(headers.substring(0, headers.indexOf(":")), headers.substring(headers.indexOf(":") + 1, headers.indexOf(";"))));
                headers = headers.substring(headers.indexOf(";")+1);
            } else{
                headerList.add(new HeadersDTO(headers.substring(0, headers.indexOf(":")), headers.substring(headers.indexOf(":") + 1)));
                headers = "";
            }
        }

        jsonKafkaMessage.put("message", jsonMap.get("message"));
        jsonKafkaMessage.put("headers", headerList);
        jsonKafkaMessage.put("topic", jsonMap.get("topic"));

        try (Writer writer = new FileWriter(folder +"/" + jsonMap.get("topic") + ".json", true)) {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            gson.toJson(jsonKafkaMessage, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
