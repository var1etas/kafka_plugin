package com.example.demo.kafka_plugin.UI;

import com.intellij.ui.components.JBBox;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import java.util.HashMap;
import java.util.Map;

public class FillFormUI {

    public Map<String, String> getMap(){
        JFrame f = new JFrame("ExerciseOptions v1.0");

        Box topicBox = new JBBox(BoxLayout.X_AXIS);
        JLabel topicLabel = new JLabel("Enter topic: ");
        JTextField topicText = new JTextField();
        topicBox.add(topicLabel);
        topicBox.add(topicText);

        Box headerBox = new Box(BoxLayout.X_AXIS);
        JLabel headerLabel = new JLabel("Enter headers: ");
        JTextField headerText = new JTextField();
        headerBox.add(headerLabel);
        headerBox.add(headerText);

        Box messageBox = new JBBox(BoxLayout.X_AXIS);
        JLabel messageLabel = new JLabel("Enter message: ");
        JTextField messageText = new JTextField();
        messageBox.add(messageLabel);
        messageBox.add(messageText);

        JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getDefaultDirectory());

        int result = JOptionPane.showOptionDialog(f,
                new Object[] {topicBox, headerBox, messageBox, chooser},
                "New Message", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, null, null);

        if (result == JOptionPane.OK_OPTION)
            System.out.println(topicText.getText() +
                    " " + headerText.getText() +
                    " " + messageText.getText() +
                    " " + chooser.getCurrentDirectory().getPath());

        Map<String, String> fillField = new HashMap<>();
        fillField.put("topic", topicText.getText());
        fillField.put("headers", headerText.getText());
        fillField.put("message", messageText.getText());
        fillField.put("directory", chooser.getCurrentDirectory().getPath());

        return fillField;
    }
}
