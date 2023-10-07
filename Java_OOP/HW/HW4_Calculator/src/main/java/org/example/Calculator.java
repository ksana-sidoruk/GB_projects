package org.example;
import java.util.List;

public class Calculator {

    /**
     * @apiNote суммирует элементы коллекции
     * @param numbers принимает на вход коллекцию
     * @return сумму элементов
     */
    public double sum(List<? extends Number> numbers) {
        double result = 0;
        for (Number number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }

    /**
     * @apiNote умножает элементы коллекции
     * @param numbers принимает на вход коллекцию
     * @return произведение элементов
     */
    public double multiply(List<? extends Number> numbers) {
        double result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                result = numbers.get(i).doubleValue();
            } else {
                result *= numbers.get(i).doubleValue();
            }
        }
        return result;
    }

    /**
     * @apiNote последовательно делит элементы коллекции
     * @param numbers принимает на вход коллекцию
     * @return результат последовательного деления элементов коллекции
     */
    public double divide(List<? extends Number> numbers) throws Exception {

        if (numbers.stream().skip(1).anyMatch(number -> number.equals(0)))
            throw new Exception("Ошибка. На ноль делить нельзя");
        double result = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (i == 0) {
                result = numbers.get(i).doubleValue();
            } else {
                result /= numbers.get(i).doubleValue();
            }
        }
        return result;
    }

    /**
     * @apiNote переводит введенное число из десятичной в двоичную систему счисления
     * @param input принимает на вход переменную типа T, проверяет, можно ли из нее сделать число
     * @return число в двоичной системе счисления
     */
    public static <T> String binary(T input) throws Exception {

        double number = 0;
        try{
            number = Double.parseDouble(input.toString());
        }catch (Exception ex){
            throw new Exception("Неверный параметр для калькулятора, введено не число");
        }

        String resultFirst = "";
        String resultSecond = "";
        int first = (int) number;
        double second = number - first;
        while (first > 0) {
            resultFirst += String.valueOf(first % 2);
            first = first / 2;
        }

        while (resultSecond.length() < 5) {
            second = second * 2;
            if (second < 1) {
                resultSecond += String.valueOf(0);
            } else {
                resultSecond += String.valueOf(1);
                second = second - 1;
            }
        }
        String result = resultFirst + "." + resultSecond;
        return result;
    }
}
