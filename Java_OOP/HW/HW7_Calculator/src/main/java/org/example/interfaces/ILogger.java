package org.example.interfaces;

public interface ILogger {

    /**
     * Выводит в консоль сообщения о совершенных операциях.
     *
     * @param message для консоли.
     */
    void logDebug(String message);

    /**
     * Выводит в консоль сообщения об ошибках, в случае их наличия.
     *
     * @param message для консоли.
     */
    void logError(String message);
}
