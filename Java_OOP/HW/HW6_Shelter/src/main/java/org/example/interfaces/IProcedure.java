package org.example.interfaces;

import java.time.LocalDate;

public interface IProcedure {
    IProcedure execute(int animalID);
    int getAnimalID();
    LocalDate getDateOfTreatment();
    String getNameofProcedure();
}
