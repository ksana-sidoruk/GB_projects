package org.example.controller;

import org.example.data.LogLevel;
import org.example.service.Calculator;
import org.example.data.ComplexNumber;
import org.example.interfaces.ICalculator;
import org.example.interfaces.IOperation;
import org.example.operations.DivideOperation;
import org.example.operations.MultiplyOperation;
import org.example.operations.SumOperation;
import org.example.service.ConsoleLogger;

import java.util.ArrayList;
import java.util.Arrays;


public class Controller {
    ICalculator calculator;

    /**
     * Конструктор класса, инициализирующий калькулятор с набором операций и логгером.
     *
     * @param mode Режим логирования для консоли.
     */
    public Controller(LogLevel mode) {
        this.calculator = new Calculator(new ArrayList<IOperation>(Arrays.asList
                (new SumOperation(),
                new MultiplyOperation(),
                new DivideOperation())), new ConsoleLogger(mode));
    }
    /**
     * Метод выполняют операцию сложения двух комплексных чисел.
     *
     * @param value1 Первое комплексное число.
     * @param value2 Второе комплексное число.
     * @return Результат выполнения операции.
     * @throws Exception Исключение, если операция не может быть выполнена.
     */
    // TODO: разобраться с исключением, т.к. вообще-то оно касается только операции деления
    public ComplexNumber sum(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("+", value1, value2);
    }
    /**
     * Метод выполняют операцию умножения двух комплексных чисел.
     *
     * @param value1 Первое комплексное число.
     * @param value2 Второе комплексное число.
     * @return Результат выполнения операции.
     * @throws Exception Исключение, если операция не может быть выполнена.
     */
    public ComplexNumber multiply(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("*", value1, value2);
    }
    // TODO: разобраться с исключением, т.к. вообще-то оно касается только операции деления
    /**
     * Метод выполняют операцию деления двух комплексных чисел.
     *
     * @param value1 Первое комплексное число.
     * @param value2 Второе комплексное число.
     * @return Результат выполнения операции.
     * @throws Exception Исключение, если операция не может быть выполнена.
     */
    public ComplexNumber divide(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("/", value1, value2);
    }
}
