package org.example.service;

import org.example.data.Animal;
import org.example.interfaces.IAnimalStorage;

import java.util.ArrayList;

public class AnimalStorage implements IAnimalStorage {

    protected ArrayList<Animal> animalStorage;
    private int currentAvailableID = 0;
    public AnimalStorage() {
        animalStorage = new ArrayList<>();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalStorage.add(animal);
        animal.setAnimalID(currentAvailableID);
        currentAvailableID++;
    }
    @Override
    public void removeAnimal(int animalID) {
        Animal result = null;
        for (Animal animal : animalStorage) {
            if (animal.getAnimalID() == animalID) {
                result = animal;
            }
        }
        animalStorage.remove(result);
    }
    @Override
    public Animal getAnimalByID(int animalID) {
        Animal result = null;
        for (Animal animal : animalStorage) {
            if (animal.getAnimalID() == animalID) {
                result = animal;
            }
        }
        return result;
    }
    @Override
    public ArrayList<Animal> getAllAnimals() {
        return animalStorage;
    }
}
