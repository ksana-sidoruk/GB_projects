package org.example;

public interface Game {
    /**
     * @apiNote принимает данные для загадываемого набора символов и запускает игру
     * @param sizeWord количество символов
     * @param maxTry количество попыток
     */
    void start(Integer sizeWord, Integer maxTry);

    /**
     * @apiNote считает количество совпадений символов в загаданном и введенном пользователем наборе
     * @param value догадка пользователя
     * @return количество "быков", "коров" и оставшихся попыток
     */
    Answer inputValue(String value);

    /**
     *
     * @return текущий статус игры
     */
    GameStatus getGameStatus();

    /**
     *
     * @return загаданный компьютером набор символов
     */
    String getComputerWord();

    /**
     * @apiNote красивый вывод статуса игры
     * @return текущий статус игры
     */
    String printGameStatus();
}
