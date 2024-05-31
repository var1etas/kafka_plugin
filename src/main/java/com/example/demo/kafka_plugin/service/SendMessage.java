package com.example.demo.kafka_plugin.service;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;

public class SendMessage {
    public void send(File dir) {
        Map<String, String> json = new HashMap<>();
        StringBuilder jsonString = new StringBuilder();
        try (FileReader reader = new FileReader(dir)) {
            int character;
            while ((character = reader.read()) != -1) {
                //System.out.print((char) character);
                jsonString.append((char) character);
                //System.out.println(jsonString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String topics = jsonString.substring(jsonString.indexOf(":")+3,jsonString.indexOf(",")-1);
        jsonString.deleteCharAt(jsonString.indexOf(":"));
        jsonString.deleteCharAt(jsonString.indexOf(","));
        String headers = jsonString.substring(jsonString.indexOf(":")+3,jsonString.indexOf(",")-1);
        jsonString.deleteCharAt(jsonString.indexOf(":"));
        jsonString.deleteCharAt(jsonString.indexOf(","));
        String message = jsonString.substring(jsonString.indexOf(":")+3,jsonString.indexOf("}")-2);
        System.out.println(topics);
        System.out.println(headers);
        System.out.println(message);

        List<Header> headersList = new ArrayList<>();
        headersList.add(new RecordHeader("headers", headers.getBytes()));
        new Producer().SendMessage(topics, message, headersList);
    }
}
