package org.example.service;

import org.example.data.ComplexNumber;
import org.example.interfaces.ICalculator;
import org.example.interfaces.ILogger;
import org.example.interfaces.IOperation;

import java.util.ArrayList;
import java.util.Optional;

public class Calculator implements ICalculator {
    private ArrayList<IOperation> availableOperations;
    private final ILogger logger;


    public Calculator(ArrayList<IOperation> availableOperations, ILogger logger) {
        this.availableOperations = availableOperations;
        this.logger = logger;
    }
    /**
     * Метод executeOperation выполняет заданную операцию над комплексными числами.
     *
     * @param operation операция (сложение, умножение, деление)
     * @param value1    первое комплексное число
     * @param value2    второе комплексное число
     * @return результат выполнения операции
     */
    @Override
    public ComplexNumber executeOperation(String operation, ComplexNumber value1, ComplexNumber value2) {
        logger.logDebug(String.format("Operation %1$s with values %2$s and %3$s was called", operation, value1.toString(), value2.toString()));
        Optional<IOperation> operationImplementation = availableOperations.stream()
                .filter(x -> x.getOperationName().equals(operation))
                .findFirst();

        if (operationImplementation.isPresent()) {
            try {
                ComplexNumber result = operationImplementation.get().execute(value1, value2);
                logger.logDebug(String.format("Operation %1$s with values %2$s and %3$s has result %4$s", operation, value1, value2, result));
                return result;
            } catch (Exception ex) {
                logger.logError(String.format("Operation %1$s has error with message: %2$s", operation, ex.getMessage()));
                return null;
            }

        } else {
            logger.logError(String.format("Operation %1$s is not supported", operation));
            return null;
        }
    }
}
