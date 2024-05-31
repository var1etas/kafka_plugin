package com.example.demo.kafka_plugin.UI;

import com.example.demo.kafka_plugin.service.SendMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SendFormUI {
    SendMessage message = new SendMessage();

    public void showForm() {
        JFrame sendForm = new JFrame();

        JFileChooser chooser = new JFileChooser();
        String dir = new File(".").getAbsolutePath();
        chooser.setCurrentDirectory(new File(dir));
        JButton send = new JButton("Send");

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(chooser.getSelectedFile().toString());
                message.send(chooser.getSelectedFile());
            }
        });

        int result = JOptionPane.showOptionDialog(sendForm,
                new Object[]{chooser},
                "Send message", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, new Object[] {send}, null);

    }
}
