package com.example.demo.kafka_plugin.UI;

import com.example.demo.kafka_plugin.service.MessageConverter;

import javax.swing.*;

public class FormChangerUI {
    public void showForm() {
        JFrame changer = new JFrame();

        JButton fillForm = new JButton("New message");
        fillForm.addActionListener(e -> {
            changer.setVisible(false);
            MessageConverter saver = new MessageConverter();
            saver.save(new FillFormUI().getMap());
        });

        JButton sendForm = new JButton("Send message");
        sendForm.addActionListener(e -> {
            changer.setVisible(false);
            SendFormUI sendFormUI = new SendFormUI();
            sendFormUI.showForm();
        });

        int result = JOptionPane.showOptionDialog(changer,
                new Object[]{fillForm, sendForm},
                "Send message", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, new Object[] {fillForm, sendForm}, null);

    }
}
