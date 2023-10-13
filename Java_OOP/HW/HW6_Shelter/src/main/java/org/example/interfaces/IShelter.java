package org.example.interfaces;

import org.example.data.Animal;

import java.util.ArrayList;

public interface IShelter {
    void addAnimal(Animal animal);
    void removeAnimal(int animalID);
    Animal getAnimalByID(int animalID);
    ArrayList<Animal> getAllAnimals();

    IProcedure executeProcedure(String name, int animalID);

    ArrayList<String> getAnimalNextProcedureByID(int animalID);

    ArrayList<IProcedure> getAllAnimalProcedures();

    ArrayList<IProcedure> getAnimalProceduresByID(int animalID);
}
