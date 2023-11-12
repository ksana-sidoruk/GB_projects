package org.example.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserParser {
    /**
     * Метод, предназначенный для создания объекта User из входной строки.
     *
     * @param inputString Входная строка с данными пользователя
     * @return Объект User
     * @throws InvalidUserInputException Возникает, если входная строка имеет недопустимый формат
     */
    public static User parseUserFromString(String inputString) throws InvalidUserInputException {

        String[] inputParams = inputString.split(" ");
        if(inputParams.length != 5){
            throw new InvalidUserInputException("Введен не правильное количество аргументов");
        }

        User result = new User();
        result.firstName = inputParams[0];
        result.lastName = inputParams[1];

        try{
            result.phoneNumber = Integer.parseInt(inputParams[2]);
        }catch (NumberFormatException exception){
            throw new InvalidUserInputException("Телефонный номер должен быть введен как целое беззнаковое число");
        }

        result.gender = inputParams[3];

        if (!result.gender.toLowerCase().equals("m") && !result.gender.toLowerCase().equals("f")) {
            throw new InvalidUserInputException("Неверный формат пола. Пол должен быть F или M");
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            result.birthDate = LocalDate.parse(inputParams[4], formatter);
        }catch (Exception ex){
            throw new InvalidUserInputException("Неверный формат даты рождения");
        }
        return result;
    }
}
