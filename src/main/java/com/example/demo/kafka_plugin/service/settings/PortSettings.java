package com.example.demo.kafka_plugin.service.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import lombok.Getter;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

@State(
        name = "org.intellij.sdk.settings.AppSettings",
        storages = @Storage("SdkSettingsPlugin.xml")
)
public final class PortSettings
        implements PersistentStateComponent<PortSettings.State> {

    public static class State {
        @NonNls
        @Getter
        public String port = "localhost:9092";
    }

    private State myState = new State();

    public static PortSettings getInstance() {
        return ApplicationManager.getApplication()
                .getService(PortSettings.class);
    }

    @Override
    public State getState() {
        return myState;
    }

    @Override
    public void loadState(@NotNull State state) {
        myState = state;
    }

}