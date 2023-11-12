package org.example;

import org.example.controller.Controller;
import org.example.data.ComplexNumber;
import org.example.data.LogLevel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        start();
    }
    /**
     * Метод, отвечающий за запуск калькулятора.
     * В данном методе осуществляется выбор режима и взаимодействие с пользователем.
     *
     * @throws Exception возможное исключение
     */
    static void start() throws Exception {

        Scanner scanner = new Scanner(System.in);
        String menu = "Необходимо выбрать, в каком режиме вы будете запускать калькулятор. Нажмите: \n" +
                "1, если хотите запустить калькулятор с логированием каждой операции\n" +
                "любую другую цифру, если это будет просто калькулятор\n";
        System.out.println(menu);
        int choice = scanner.nextInt();
        Controller controller = null;
        switch (choice) {
            case (1) -> {
                System.out.println("запускаем калькулятор с логированием");
                controller = new Controller(LogLevel.Debug);
            }
            default -> {
                System.out.println("запускаем калькулятор");
                controller = new Controller(LogLevel.Regular);
            }
        }

        boolean exit = false;
        while (!exit) {
            String menuCalcualtor = "В калькуляторе комплексных чисел вам доступны следующие операции: \n" +
                    "1. Сложение\n" +
                    "2. Умножение\n" +
                    "3. Деление \n" +
                    "Если хотите выйти - введите любую цифру";
            System.out.println(menuCalcualtor);
            int choiceOfOperation = scanner.nextInt();
            System.out.println("Последовательно введите реальную и мнимую части первого комплексного числа");
            int real1 = scanner.nextInt();
            int imaginary1 = scanner.nextInt();
            ComplexNumber number1 = new ComplexNumber(real1, imaginary1);
            System.out.println("Последовательно введите реальную и мнимую части второго комплексного числа");
            int real2 = scanner.nextInt();
            int imaginary2 = scanner.nextInt();
            ComplexNumber number2 = new ComplexNumber(real2, imaginary2);

            switch (choiceOfOperation) {
                case (1) -> {
                    System.out.println("Результат сложения: " + controller.sum(number1, number2));

                }
                case (2) -> {
                    System.out.println("Результат умножения: " + controller.multiply(number1, number2));
                }
                case (3) -> {
                    System.out.println("Результат деления: " + controller.divide(number1, number2));
                }
                case (4) -> {
                    System.out.println("До новых встреч");
                    exit = true;
                }
                default -> System.out.println(menuCalcualtor);
            }
        }
    }
}