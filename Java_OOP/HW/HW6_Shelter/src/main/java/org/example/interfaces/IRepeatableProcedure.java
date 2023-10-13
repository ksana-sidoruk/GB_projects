package org.example.interfaces;

import java.time.LocalDate;

public interface IRepeatableProcedure extends IProcedure {
    LocalDate  getDateOfNextProcedure();

}
