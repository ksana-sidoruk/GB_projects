package org.example.data;

import org.example.interfaces.IProcedure;
import org.example.interfaces.IRepeatableProcedure;

import java.time.LocalDate;

public class AntiParasitesTreatment extends ProcedureBase implements IRepeatableProcedure {
    protected String name = "противопаразитарная обработка";
    protected LocalDate dateOfNextProcedure;

    public AntiParasitesTreatment(int animalID) {
        super.dateOfTreatment = LocalDate.now();
        super.name = this.name;
        super.animalID = animalID;
        this.dateOfNextProcedure = super.dateOfTreatment.plusDays(90);
    }

    public AntiParasitesTreatment() {
    }

    @Override
    public IProcedure execute(int animalID) {
        return new AntiParasitesTreatment(animalID);
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
