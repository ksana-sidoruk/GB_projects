package org.example.data;

import lombok.Data;
import org.example.interfaces.IProcedure;

import java.time.LocalDate;


public class Castration extends ProcedureBase implements IProcedure {
    protected String name = "кастрация";

    public Castration(int animalID) {
       super(animalID);
       super.name = this.name;
       super.dateOfTreatment = LocalDate.now();

    }

    public Castration() {
    }

    @Override
    public IProcedure execute(int animalID) {
        return new Castration(animalID);
    }

    @Override
    public LocalDate getDateOfTreatment() {
        return super.dateOfTreatment;
    }

    @Override
    public String getNameofProcedure() {
        return name;
    }
}
