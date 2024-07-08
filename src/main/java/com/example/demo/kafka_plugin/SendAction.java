package com.example.demo.kafka_plugin;

import com.example.demo.kafka_plugin.UI.FormChangerUI;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import org.jetbrains.annotations.NotNull;

public class SendAction extends AnAction {
    FormChangerUI changerUI = new FormChangerUI();
    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        changerUI.showForm();
    }
}
