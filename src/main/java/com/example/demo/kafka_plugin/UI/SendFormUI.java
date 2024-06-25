package com.example.demo.kafka_plugin.UI;

import com.example.demo.kafka_plugin.service.MessageConverter;
import com.example.demo.kafka_plugin.service.Producer;

import javax.swing.*;
import java.io.File;

public class SendFormUI {
    MessageConverter messageConverter = new MessageConverter();

    public void showForm() {
        JFrame sendForm = new JFrame();

        JFileChooser chooser = new JFileChooser();
        String dir = new File(".").getAbsolutePath();
        chooser.setCurrentDirectory(new File(dir));
        JButton send = new JButton("Send");

        send.addActionListener(e -> {
            System.out.println(chooser.getSelectedFile().toString());
            new Producer().SendMessage(messageConverter.read(chooser.getSelectedFile()));
        });

        int result = JOptionPane.showOptionDialog(sendForm,
                new Object[]{chooser},
                "Send message", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new Object[] {send}, null);

    }
}
