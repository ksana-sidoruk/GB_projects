package org.example;

import org.example.data.InvalidUserInputException;
import org.example.data.User;
import org.example.data.UserParser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите последовательно через пробел ФИО, номер телефона, пол в формате f/m, дату рождения");
        String input = scanner.nextLine();
        User user = null;

        try {
            user = UserParser.parseUserFromString(input);
        } catch (InvalidUserInputException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Неожидаемая ошибка!");
        }

        try{
            PrintToFile(user);
        }
        catch (IOException ex){
            System.out.println("Ошибка при записи в файл");
        }
    }
    /**
     * Метод позволяет осуществлять запись данных пользователя в файл. Однофамильцы записываются в один файл
     *
     * @param user данные пользователя, которые будут записаны в файл.
     * @throws IOException Исключение, если операция не может быть выполнена.
     */
    private static void PrintToFile(User user) throws IOException {
        FileWriter fileWriter = new FileWriter(user.lastName + ".txt", true);
        var resultString = String.format("<%s><%s><%d><%s><%s>", user.firstName, user.lastName, user.phoneNumber, user.gender, user.birthDate.toString());
        System.out.println(resultString);
        fileWriter.write(resultString + "\n");
        fileWriter.close();
    }
}