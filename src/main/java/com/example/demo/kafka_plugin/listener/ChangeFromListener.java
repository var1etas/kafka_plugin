package com.example.demo.kafka_plugin.listener;
import com.example.demo.kafka_plugin.UI.FillFormUI;
import com.example.demo.kafka_plugin.UI.SendFormUI;
import com.example.demo.kafka_plugin.service.MessageConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeFromListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("LoadFillFrom")) {
            MessageConverter saver = new MessageConverter();
            saver.save(new FillFormUI().getMap());
        } else {
            SendFormUI sendFormUI = new SendFormUI();
            sendFormUI.showForm();
        }
    }
}