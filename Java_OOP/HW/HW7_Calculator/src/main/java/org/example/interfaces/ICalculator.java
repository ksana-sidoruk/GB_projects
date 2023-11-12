package org.example.interfaces;

import org.example.data.ComplexNumber;


public interface ICalculator {
    /**
     * Выполняет операцию над двумя комплексными числами.
     *
     * @param operation Выбранная операция (например, сейчас реализованы сложение, умножение, деление).
     * @param value1    Первое комплексное число.
     * @param value2    Второе комплексное число.
     * @return Результат операции в виде нового комплексного числа.
     */
    public ComplexNumber executeOperation(String operation, ComplexNumber value1, ComplexNumber value2);
}
