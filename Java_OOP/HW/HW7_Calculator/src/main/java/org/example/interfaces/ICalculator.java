package org.example.interfaces;

import org.example.data.ComplexNumber;

import java.util.List;

public interface ICalculator {
    public ComplexNumber executeOperation(String operation, ComplexNumber value1, ComplexNumber value2);
}
