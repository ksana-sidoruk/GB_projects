package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(new ArrayList<>(Arrays.asList(1, 2, 3))));
        System.out.println(calculator.multiply(new ArrayList<>(Arrays.asList(1, 2, 5.3)))); // 10,6
        System.out.println(calculator.divide(new ArrayList<>(Arrays.asList(5.4, 3, 2)))); // 0,9
        System.out.println(calculator.binary(31.141));
        System.out.println(calculator.divide(new ArrayList<>(Arrays.asList(1, 0, 5.3)))); // ошибка


    }
}