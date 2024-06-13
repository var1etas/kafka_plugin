package com.example.demo.kafka_plugin.UI;

import com.intellij.ui.table.JBTable;

import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class FillFormUI {

    public Map<String, String> getMap(){
        JFrame f = new JFrame("ExerciseOptions v1.0");

        JTextField topics = new JTextField(70);
        JLabel topicLabel = new JLabel("Enter topic:        ");
        JTextField headers = new JTextField(70);
        JLabel headerLabel = new JLabel("Enter headers:   ");
        JTextField message = new JTextField(70);
        JLabel messageLabel = new JLabel("Enter message:  ");

        JFileChooser chooser = new JFileChooser();
        chooser.setApproveButtonText("New file");

        JPanel topicPanel = new JPanel();
        topicPanel.add(topicLabel);
        topicPanel.add(topics);

        JPanel headersPanel = new JPanel();
        headersPanel.add(headerLabel);
        headersPanel.add(headers);
        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel);
        messagePanel.add(message);

        int result = JOptionPane.showOptionDialog(f,
                new Object[] {topicPanel, headersPanel, messagePanel, chooser},
                "New Message", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
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
