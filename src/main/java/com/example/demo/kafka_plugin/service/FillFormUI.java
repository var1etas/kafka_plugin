package com.example.demo.kafka_plugin.service;

import javax.swing.*;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class FillFormUI {

    public Map<String, String> getMap(){
        JFrame f = new JFrame("ExerciseOptions v1.0");
        JTextField topics = new JTextField();
        JTextField headers = new JTextField();
        JTextField message = new JTextField();
        String description = "Please enter topics, headers and message.";
        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("New file");

        int result = JOptionPane.showOptionDialog(f,
                new Object[] {topics, headers, message, chooser},
                "New Message", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);

        if (result == JOptionPane.OK_OPTION)
            System.out.println(topics.getText() +
                    " " + headers.getText() +
                    " " + message.getText() +
                    " " + chooser.getSelectedFile().toString());

        Map<String, String> fillField = new LinkedHashMap<>();
        fillField.put("topics", topics.getText());
        fillField.put("headers", headers.getText());
        fillField.put("message", message.getText());
        fillField.put("directory", chooser.getSelectedFile().toString());

        return fillField;
    }
}
