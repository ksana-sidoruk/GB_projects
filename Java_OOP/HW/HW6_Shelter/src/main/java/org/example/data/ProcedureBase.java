package org.example.data;

import org.example.interfaces.IProcedure;
import java.time.LocalDate;

public abstract class ProcedureBase implements IProcedure {
    protected String name;
    protected LocalDate dateOfTreatment;
    protected int animalID;

    public ProcedureBase(int animalID) {
        this.dateOfTreatment = LocalDate.now();
        this.animalID = animalID;
    }

    public ProcedureBase() {
    }

    public String toString() {
        return "Процедура: " + name +
                ", дата проведения: " + dateOfTreatment +
                ", ID жителя приюта: " + animalID;
    }

    @Override
    public abstract IProcedure execute(int animalID);

    @Override
    public int getAnimalID() {
        return animalID;
    }

}
