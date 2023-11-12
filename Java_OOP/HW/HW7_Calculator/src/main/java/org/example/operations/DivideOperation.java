package org.example.operations;

import org.example.data.ComplexNumber;
import org.example.interfaces.IOperation;

public class DivideOperation implements IOperation {


    @Override
    public ComplexNumber execute(ComplexNumber value1, ComplexNumber value2) {
        // Проверка деления на 0
        if (value2.getReal() == 0 && value2.getImaginary() == 0) {
            throw new ArithmeticException("Division by zero");
        }

        int realPart = (value1.getReal() * value2.getReal() + value1.getImaginary() * value2.getImaginary()) /
                (value2.getReal() * value2.getReal() + value2.getImaginary() * value2.getImaginary());

        int imaginaryPart = (value1.getImaginary() * value2.getReal() - value1.getReal() * value2.getImaginary()) /
                (value2.getReal() * value2.getReal() + value2.getImaginary() * value2.getImaginary());

        return new ComplexNumber(realPart, imaginaryPart);
    }

    @Override
    public String getOperationName() {
        return "/";
    }
}
