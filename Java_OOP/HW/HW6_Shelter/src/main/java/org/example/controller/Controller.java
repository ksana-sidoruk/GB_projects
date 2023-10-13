package org.example.controller;

import org.example.data.Animal;
import org.example.data.AntiParasitesTreatment;
import org.example.data.Castration;
import org.example.data.Vaccination;
import org.example.interfaces.IProcedure;
import org.example.interfaces.IShelter;
import org.example.service.*;
import org.example.view.ShelterView;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    IShelter shelter;
    ShelterView shelterView;


    public Controller() {
        this.shelterView = new ShelterView();
        this.shelter = new Shelter(new AnimalStorage(),
                new ArrayList<IProcedure>(Arrays.asList(new Vaccination(),
                        new AntiParasitesTreatment(), new Castration())));
    }

    public void addAnimalToShelter(Animal animal) {
        shelter.addAnimal(animal);
        shelterView.confirmNewAnimal(animal);
    }

    public void showAllAnimalsInShelter() {
        ArrayList<Animal> animals =  shelter.getAllAnimals();
        shelterView.viewAnimals(animals);

    }

    public void getAnimalByID(int animalID) {
        Animal result = shelter.getAnimalByID(animalID);
        shelterView.printAnimal(result);
    }

    public void removeAnimalFromShelter(int animalID){
        Animal animal = shelter.getAnimalByID(animalID);
        shelter.removeAnimal(animalID);
        shelterView.confirmAnimalDeparture(animal);
    }
    /**
     * @apiNote метод вызывает выполнение запрошенной процедуры в сервисе, получает результат исполнения
     * и передает его во view
     * @param name название процедуры
     * @param animalID ID животного, к которому будет применяться процедура
     */
    public void executeProcedure(String name, int animalID) {
        IProcedure result = shelter.executeProcedure(name, animalID);
        shelterView.printProcedureResult(result);
    }

    public void getAllProceduresJournal(){
        ArrayList<IProcedure> allProcedures = shelter.getAllAnimalProcedures();
        shelterView.printAllProcedures(allProcedures);
    }

    public void getProceduresByAnimalID(int animalID){
        ArrayList<IProcedure> proceduresByID = shelter.getAnimalProceduresByID(animalID);
        shelterView.printProceduresByID(proceduresByID);
    }

    public void getReminderOnProcedures(int animalID){
        ArrayList<String> nextProcedures = shelter.getAnimalNextProcedureByID(animalID);
        shelterView.printNextProcedures(nextProcedures);
    }

}
