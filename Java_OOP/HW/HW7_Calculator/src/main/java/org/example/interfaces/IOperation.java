package org.example.interfaces;

import org.example.data.ComplexNumber;

public interface IOperation {

    /**
     * Выполняет операцию над двумя комплексными числами.
     *
     * @param value1 Первое комплексное число.
     * @param value2 Второе комплексное число.
     * @return Результат операции в виде комплексного числа.
     */
    public ComplexNumber execute(ComplexNumber value1, ComplexNumber value2);


    /**
     * Возвращает название операции.
     *
     * @return Название операции.
     */
    public String getOperationName();
}
