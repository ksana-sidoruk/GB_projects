package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game newgame = menu();
        if (newgame != null) {
            newgame.start(5, 2);

            ArrayList<String> gamelog = new ArrayList<>();

            while (newgame.getGameStatus() != GameStatus.WIN && newgame.getGameStatus() != GameStatus.LOSE) {
                System.out.println("Введите вашу догадку");
                Scanner scanner = new Scanner(System.in);
                String guess = scanner.nextLine();
                Answer answer = newgame.inputValue(guess);
                System.out.println(answer);
                System.out.println(newgame.printGameStatus());
                gamelog.add("Загаданное слово: " + newgame.getComputerWord() + ". Введенное слово: " + guess +
                        ". Статус игры: " + newgame.printGameStatus() + ". " + answer);
            }
            reinitialization(gamelog);
        }
    }


    /**
     * @return игру с тем или иным набором символов
     * @apiNote запускает меню, позволяющее пользователю выбрать вид игры или выйти
     */
    static Game menu() {
        Game newgame = null;
        System.out.println("Для запуска игры введите число: \n" +
                "1 - если хотите игру с цифрами \n" +
                "2 - если хотите игру с кириллицей \n" +
                "3 - если хотите игру с латиницей \n" +
                "напечатайте, что-нибудь еще, если хотите завершить сессию и ВЫЙТИ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> newgame = new NumberGame();
            case "2" -> newgame = new RuGame();
            case "3" -> newgame = new EnGame();
            default -> System.out.println("Ну пока!");
        }
        return newgame;
    }

    /**
     * @param gameLog, список с "логами"
     * @apiNote после того, как игра завершилась, позволяет вывести логи последней игры, перезапустить игру или выйти
     */
    static void reinitialization(ArrayList<String> gameLog) {
        System.out.println("=================================\nТекущая игра завершена, нажмите: \n" +
                "1 - если хотите посмотреть логи предыдущей игры \n" +
                "2 - если хотите начать заново \n" +
                "напечатайте, что-нибудь еще, если хотите завершить сессию и ВЫЙТИ");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        switch (choice) {
            case "1" -> {
                int i = 1;
                for (String log : gameLog) {
                    System.out.println("Попытка № " + i + ": " + log);
                    i++;
                }
            }
            case "2" -> menu();
            default -> System.out.println("Пока-пока!");
        }
    }
}
