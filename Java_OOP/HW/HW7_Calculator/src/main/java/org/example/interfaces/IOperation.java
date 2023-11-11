package org.example.interfaces;

import org.example.data.ComplexNumber;

public interface IOperation {
    public ComplexNumber execute(ComplexNumber value1, ComplexNumber value2);

    public String getOperationName();
}
