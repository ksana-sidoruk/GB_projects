package org.example.operations;

import org.example.data.ComplexNumber;
import org.example.interfaces.IOperation;

public class SumOperation implements IOperation {

    /**
     * Реализует операцию сложения для двух комплексных чисел.
     *
     * @param value1    Первое комплексное число.
     * @param value2    Второе комплексное число.
     * @return Результат операции в виде нового комплексного числа.
     */
    @Override
    public ComplexNumber execute(ComplexNumber value1, ComplexNumber value2) {
        return new ComplexNumber(value1.getReal()+ value2.getReal(), value1.getImaginary()+ value2.getImaginary());
    }

    @Override
    public String getOperationName() {
        return "+";
    }
}
