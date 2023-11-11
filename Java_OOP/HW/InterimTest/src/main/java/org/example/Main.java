package org.example;

import org.example.data.PrizeToy;
import org.example.data.Toy;
import org.example.services.IStoreService;
import org.example.services.StoreService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        IStoreService store = new StoreService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество игрушек, которое будем генерировать");
        var toysToGenerateCount = scanner.nextInt();
        GenerateToys(store, toysToGenerateCount);

        System.out.println("Сколько игрушек будем выдавать как приз?");
        var prizeToysCount = scanner.nextInt();
        store.GeneratePrizePool(prizeToysCount);
        ReleasePrizeAndWriteInFile(store);
    }

    private static void GenerateToys(IStoreService store, int toysToGenerateCount) {
        Random random = new Random();
        String[] prefixes = {"Супер", "Мега", "Ультра", "Мини"};
        String[] suffixes = {"Робот", "Дроид", "Динозавр", "Пупс", "Лего"};
        String[] unusualNames = {"Робот Мегатрон", "Кукла Барби",  "Гусь-за-лицо-кусь", "Бесполезный pop-it", "Игрушечный молоток", "Старомодный спиннер"};
        System.out.println("На настоящий момент на складе магазина хранятся игрушки:");
        for (int i = 0; i < toysToGenerateCount; i++) {
            int id = i + 1;
            int count = random.nextInt(3) + 1;
            int weight = random.nextInt(100) + 1;

            String name;
            if (random.nextBoolean()) {
                name = prefixes[random.nextInt(prefixes.length)] + suffixes[random.nextInt(suffixes.length)];
            } else {
                name = unusualNames[random.nextInt(unusualNames.length)];
            }

            System.out.printf("ID: %d, Название: %s, Количество игрушек на складе: %d, Вероятность выпадения: %d", id, name, count, weight);
            System.out.println();
            store.AddToy(new Toy(id, weight, name, count));
        }
    }

    public static void ReleasePrizeAndWriteInFile(IStoreService store) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt", false);
        PrizeToy toy = null;
        do {
            toy = store.ReleasePrizeToy();
            if (toy != null) {
                fileWriter.write(toy.name + " " + toy.weight + "%" + "\n");
            }
        } while (toy != null);
        fileWriter.close();
    }
}