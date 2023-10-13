package org.example;

import org.example.controller.Controller;
import org.example.data.Animal;
import org.example.data.Dog;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        start();
    }

    static void start() {
        Controller controller = new Controller();
        // заранее ввведенные данные по зверушкам и процедурам, чтоб можно было выводить информацию в консоль,
        // не страдая при их добавлении через свитч-кейс

        controller.addAnimalToShelter(new Dog("Арни", "цверг-шнауцер", 10));
        controller.addAnimalToShelter(new Dog("Барни", "бигль", 3));
        controller.addAnimalToShelter(new Dog("Лулу", "хахаски", 2));
        controller.executeProcedure("кастрация", 1);
        controller.executeProcedure("вакцинация", 2);
        controller.executeProcedure("вакцинация", 1);
        controller.executeProcedure("противопаразитарная обработка", 1);
        controller.executeProcedure("противопаразитарная обработка", 0);
        controller.executeProcedure("противопаразитарная обработка", 2);
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        String menu = "Приветствуем вас в системе учета Приюта. Вам доступны следующие процедуры: \n" +
                "1. Добавить жителя в Приют\n" +
                "2. Получить информацию обо всех жителях Приюта\n" +
                "3. Получить информацию о жителе Приюта по его ID \n" +
                "4. Исключить информацию о жителе Приюта - он нашел новый дом\n" +
                "5. Выполнить процедуру в отношении жителя Приюта\n" +
                "6. Получить информацию о всех процедурах, выполненных в отношении жителей Приюта\n" +
                "7. Получить информацию о всех процедурах, выполненных в отношении конкретного жителя Приюта\n" +
                "8. Получить информацию о просроченных процедурах в отношении конкретного жителя Приюта\n" +
                "9. Выйти из системы \n" +
                "Если хотите заново увидеть текст меню - введите любое число";
        System.out.println(menu);

        while (!exit) {
            int choice = scanner.nextInt();
            switch (choice) {
                case (1) -> {
                    System.out.println("введите имя, породу и возраст нового жителя Приюта");
                    String name = scanner.nextLine();
                    String breed = scanner.nextLine();
                    scanner.nextLine();
                    int age = scanner.nextInt();
                    Animal dog = new Animal(name, breed, age);
                    controller.addAnimalToShelter(dog);
                }
                case (2) -> {
                    controller.showAllAnimalsInShelter();
                }
                case (3) -> {
                    System.out.println("Введите ID жителя, которого вы ищете");
                    controller.getAnimalByID(scanner.nextInt());
                }
                case (4) -> {
                    System.out.println("Введите ID жителя, который покинул Приют");
                    controller.removeAnimalFromShelter(scanner.nextInt());
                }
                case (5) -> {
                    System.out.println("В отношении жителей Приюта можно выполнить такие процедуры: кастрация, вакцинация и " +
                            "противопаразитарная обработка. Введите название процедуры и ID жителя Приюта");
                    String name = scanner.nextLine();
                    scanner.nextLine();
                    int ID = scanner.nextInt();
                    controller.executeProcedure(name, ID);
                }
                case (6) -> {
                    System.out.println("Выводим журнал всех процедур в отношении всех жителей Приюта");
                    controller.getAllProceduresJournal();
                }
                case (7) -> {
                    System.out.println("Введите ID жителя Приюта, чтоб получить запрошенную информацию");
                    int ID = scanner.nextInt();
                    controller.getProceduresByAnimalID(ID);
                }
                case (8) -> {
                    System.out.println("Введите ID жителя Приюта, чтоб получить запрошенную информацию");
                    int ID = scanner.nextInt();
                    controller.getReminderOnProcedures(ID);
                }
                case (9) -> {
                    System.out.println("До новых встреч");
                    exit = true;
                }
                default -> System.out.println(menu);
            }
        }
    }
}