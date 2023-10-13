package org.example.view;

import org.example.data.Animal;
import org.example.interfaces.IProcedure;

import java.util.ArrayList;

public class ShelterView {

    public void confirmNewAnimal(Animal animal) {
        if (animal != null) {
            System.out.println("В Приюте появился новый житель. " + animal + ". Его ID: " + animal.getAnimalID());
        }
    }

    public void viewAnimals(ArrayList<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("В Приюте сейчас нет животных");
            return;
        }
        for (Animal animal : animals) {
            System.out.println("ID " + animal.getAnimalID() +". " + animal);
        }
    }

    public void printAnimal(Animal animal) {
        if (animal == null) {
            System.out.println("В Приюте нет такого животного");
        } else {
            System.out.println(animal);
        }
    }

    public void printProcedureResult(IProcedure procedure) {
        if (procedure != null) {
            System.out.println(procedure);
        } else {
            System.out.println("Такая процедура недоступна");
        }
    }

    public void printNextProcedures(ArrayList<String> nextProcedures) {
        if (nextProcedures.isEmpty()) {
            System.out.println("Этот житель Приюта обработан, время очередных обработок еще не наступило");
            return;
        }
        System.out.println(nextProcedures);
    }

    public void printAllProcedures(ArrayList<IProcedure> allProcedures) {
        if (allProcedures.isEmpty()) {
            System.out.println("В отношении жителей Приюта еще не было выполнено никаких процедур");
            return;
        }
        for (IProcedure procedure : allProcedures) {
            System.out.println(procedure);
        }
    }


    public void printProceduresByID(ArrayList<IProcedure> proceduresByID) {
        if (proceduresByID.isEmpty()) {
            System.out.println("В отношении этого жителя Приюта еще не было выполнено никаких процедур");
            return;
        }
        for (IProcedure procedure : proceduresByID) {
            System.out.println(procedure);
        }
    }

    public void confirmAnimalDeparture(Animal animal) {
        if (animal != null) {
            System.out.println("Житель Приюта " + animal.getName() + " нашел новый дом!");
        } else {
            System.out.println("В Приюте не было такого жителя");
        }
    }
}
