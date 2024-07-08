package com.example.demo.kafka_plugin.service.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

final class PortSettingsConfigurable implements Configurable {

    private PortSettingsComponent portSettingsComponent;

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Kafka-Plugin: Port Settings";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return portSettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        portSettingsComponent = new PortSettingsComponent();
        return portSettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        PortSettings.State state =
                Objects.requireNonNull(PortSettings.getInstance().getState());
        return !portSettingsComponent.getPortText().equals(state.port);
    }

    @Override
    public void apply() {
        PortSettings.State state =
                Objects.requireNonNull(PortSettings.getInstance().getState());
        state.port = portSettingsComponent.getPortText();
    }

    @Override
    public void reset() {
        PortSettings.State state =
                Objects.requireNonNull(PortSettings.getInstance().getState());
        portSettingsComponent.setPortText(state.port);
    }

    @Override
    public void disposeUIResources() {
        portSettingsComponent = null;
    }

}