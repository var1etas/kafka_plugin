package com.example.demo.kafka_plugin.service.settings;

import com.example.demo.kafka_plugin.service.Producer;
import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

final class AppSettingsConfigurable implements Configurable {
    private AppSettingsComponent mySettingsComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Kafka_plugin: Server port";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new AppSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return !mySettingsComponent.getServerPort().equals(settings.serverPort);
    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.serverPort = mySettingsComponent.getServerPort();
        Producer.setPort(mySettingsComponent.getServerPort());
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        mySettingsComponent.setServerPort(settings.serverPort);
        Producer.setPort(settings.serverPort);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }
}