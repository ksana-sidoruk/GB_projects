package org.example.data;

import org.example.interfaces.IProcedure;
import org.example.interfaces.IRepeatableProcedure;

import java.time.LocalDate;

public class Vaccination extends ProcedureBase implements IRepeatableProcedure {

    protected String name = "вакцинация";
    protected LocalDate dateOfNextProcedure;

    public Vaccination(int animalID) {
        super.dateOfTreatment = LocalDate.now();
        super.name = this.name;
        super.animalID = animalID;
        this.dateOfNextProcedure = super.dateOfTreatment.plusDays(90);
    }

    public Vaccination() {
    }

    @Override
    public IProcedure execute(int animalID) {
        return new Vaccination(animalID);
    }

    @Override
    public LocalDate getDateOfTreatment() {
        return super.dateOfTreatment;
    }

    @Override
    public String getNameofProcedure() {
        return name;
    }
    @Override
    public LocalDate getDateOfNextProcedure() {
        return dateOfNextProcedure;
    }
}
