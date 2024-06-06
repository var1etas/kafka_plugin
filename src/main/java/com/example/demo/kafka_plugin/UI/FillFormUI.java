package com.example.demo.kafka_plugin.UI;

import javax.swing.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class FillFormUI {

    public Map<String, String> getMap(){
        JFrame f = new JFrame("ExerciseOptions v1.0");
        JTextField topics = new JTextField();
        JTextField headers = new JTextField();
        JTextField message = new JTextField();
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
                    " " + chooser.getCurrentDirectory().getPath());

        Map<String, String> fillField = new LinkedHashMap<>();
        fillField.put("topic", topics.getText());
        fillField.put("headers", headers.getText());
        fillField.put("message", message.getText());
        fillField.put("directory", chooser.getCurrentDirectory().getPath());

        return fillField;
    }
}
