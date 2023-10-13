package org.example.interfaces;

import org.example.data.Animal;
import java.util.ArrayList;

public interface IAnimalStorage {
    void addAnimal(Animal animal);
    void removeAnimal(int animalID);
    Animal getAnimalByID(int animalID);
    ArrayList<Animal> getAllAnimals();
}
