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

    public Controller(LogLevel mode) {
        this.calculator = new Calculator(new ArrayList<IOperation>(Arrays.asList
                (new SumOperation(),
                new MultiplyOperation(),
                new DivideOperation())), new ConsoleLogger(mode));
    }

    public ComplexNumber Sum(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("+", value1, value2);
    }
    public ComplexNumber Multiply(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("*", value1, value2);
    }
    public ComplexNumber Divide(ComplexNumber value1, ComplexNumber value2) throws Exception {
        return calculator.executeOperation("/", value1, value2);
    }
}
