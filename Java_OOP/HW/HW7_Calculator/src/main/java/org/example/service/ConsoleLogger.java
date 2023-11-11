package org.example.service;

import org.example.data.LogLevel;
import org.example.interfaces.ILogger;

public class ConsoleLogger implements ILogger {

    private final LogLevel logLevel;

    public ConsoleLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public void logDebug(String message) {
        if (logLevel == LogLevel.Debug) {
            System.out.println("DEBUG LOG :  " + message);
        }
    }

    @Override
    public void logError(String message) {
        System.out.println("ERROR LOG :  " + message);
    }
}
