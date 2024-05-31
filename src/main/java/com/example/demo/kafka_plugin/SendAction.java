package com.example.demo.kafka_plugin;

import com.example.demo.kafka_plugin.UI.FillFormUI;
import com.example.demo.kafka_plugin.UI.FormChangerUI;
import com.example.demo.kafka_plugin.UI.SendFormUI;
import com.example.demo.kafka_plugin.service.JsonConverter;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import org.jetbrains.annotations.NotNull;


public class SendAction extends AnAction {

    FillFormUI newMessage = new FillFormUI();
    JsonConverter saver = new JsonConverter();
    FormChangerUI changerUI = new FormChangerUI();
    SendFormUI sendFormUI = new SendFormUI();
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        changerUI.showForm();
    }
}
