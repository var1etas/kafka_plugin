package com.example.demo.kafka_plugin.service.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PortSettingsComponent {
    private final JPanel portSettingsPanel;
    private final JBTextField portText = new JBTextField();

    public PortSettingsComponent() {
        portSettingsPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Server port:"), portText, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return portSettingsPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return portText;
    }

    @NotNull
    public String getPortText() {
        return portText.getText();
    }

    public void setPortText(@NotNull String newText) {
        portText.setText(newText);
    }
}