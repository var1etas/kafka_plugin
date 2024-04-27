package com.example.demo.kafka_plugin;

import com.example.demo.kafka_plugin.service.FillFormUI;
import com.example.demo.kafka_plugin.service.JsonSaver;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import org.jetbrains.annotations.NotNull;


public class SendAction extends AnAction {

    FillFormUI newMessage = new FillFormUI();
    JsonSaver saver = new JsonSaver();

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        saver.save(newMessage.getMap());
    }
}
