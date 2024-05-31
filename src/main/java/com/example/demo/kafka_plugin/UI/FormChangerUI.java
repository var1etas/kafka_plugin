package com.example.demo.kafka_plugin.UI;

import com.example.demo.kafka_plugin.listener.ChangeFromListener;

import javax.swing.*;

public class FormChangerUI {
    ChangeFromListener changeFromListener = new ChangeFromListener();
    public void showForm() {
        JFrame changer = new JFrame();

        JButton fillForm = new JButton("New message");
        fillForm.setActionCommand("LoadFillFrom");
        fillForm.addActionListener(changeFromListener);
        JButton sendForm = new JButton("Send message");
        sendForm.setActionCommand("LoadSendForm");
        sendForm.addActionListener(changeFromListener);

        int result = JOptionPane.showOptionDialog(changer,
                new Object[]{fillForm, sendForm},
                "Send message", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, new Object[] {fillForm, sendForm}, null);

    }
}
