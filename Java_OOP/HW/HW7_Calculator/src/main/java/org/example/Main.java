package org.example;

import org.example.controller.Controller;
import org.example.data.ComplexNumber;
import org.example.data.LogLevel;
import org.example.interfaces.IOperation;
import org.example.operations.DivideOperation;
import org.example.operations.MultiplyOperation;
import org.example.operations.SumOperation;
import org.example.service.Calculator;
import org.example.service.ConsoleLogger;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        ComplexNumber num1 = new ComplexNumber(-4, 2);
        ComplexNumber num2 = new ComplexNumber(0, 0);

        Controller controller = new Controller(LogLevel.Regular);
        System.out.println("sum: " + controller.Divide(num1, num2));

        System.out.println("Enter 1 to run in regular mode and 2 for debug mode");

    }
}