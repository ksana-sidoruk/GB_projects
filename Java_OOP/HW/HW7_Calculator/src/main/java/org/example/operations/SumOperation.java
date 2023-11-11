package org.example.operations;

import org.example.data.ComplexNumber;
import org.example.interfaces.IOperation;

public class SumOperation implements IOperation {

    @Override
    public ComplexNumber execute(ComplexNumber value1, ComplexNumber value2) {
        return new ComplexNumber(value1.getReal()+ value2.getReal(), value1.getImaginary()+ value2.getImaginary());
    }

    @Override
    public String getOperationName() {
        return "+";
    }
}
