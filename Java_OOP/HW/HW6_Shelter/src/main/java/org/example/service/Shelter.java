package org.example.service;

import org.example.data.Animal;
import org.example.interfaces.IAnimalStorage;
import org.example.interfaces.IProcedure;
import org.example.interfaces.IRepeatableProcedure;
import org.example.interfaces.IShelter;
import java.time.LocalDate;
import java.util.ArrayList;

public class Shelter implements IShelter {
    protected IAnimalStorage animalStorage;
    protected ArrayList<IProcedure> procedures;
    protected ArrayList<IProcedure> availableProcedures;

    public Shelter(IAnimalStorage animalStorage, ArrayList<IProcedure> availableProcedures) {
        this.animalStorage = animalStorage;
        this.availableProcedures = availableProcedures;
        procedures = new ArrayList<>();
    }

    @Override
    public void addAnimal(Animal animal) {
        animalStorage.addAnimal(animal);
    }

    @Override
    public void removeAnimal(int animalID) {
        animalStorage.removeAnimal(animalID);
    }

    @Override
    public Animal getAnimalByID(int animalID) {
        return animalStorage.getAnimalByID(animalID);
    }

    @Override
    public ArrayList<Animal> getAllAnimals() {
        return animalStorage.getAllAnimals();
    }

    /**
     * @param procedure
     * @apiNote позволяет добавить выполненную процедуру в общий список всех процедур
     */
    private void addProcedureToJournal(IProcedure procedure) {
        procedures.add(procedure);
    }

    /**
     * @param name     название процедуры к выполнению
     * @param animalID ID животного, к которому применяется процедура
     * @return выполненную процедуру (если такая доступна) или null (если нет)
     * @apiNote проверяет, есть ли в перечне доступных процедур та, название которой принято на вход. Если да - выполняет ее
     * и добавляет выполненную процедуру в общий список всех процедур. Если процедура недоступна
     */
    @Override
    public IProcedure executeProcedure(String name, int animalID) {
        for (IProcedure procedure : availableProcedures) {
            if (procedure.getNameofProcedure().equals(name)) {
                IProcedure result = procedure.execute(animalID);
                addProcedureToJournal(result);
                return result; // для себя: создаем не до цикла, а в иф, чтобы не выделялась лишняя память под переменную (если вдруг такой перменной нет)
            }
        }
        return null;
    }

    /**
     * @return список всех процедур, когда-либо выполненных в отношении всех животных шелтера
     */
    public ArrayList<IProcedure> getAllAnimalProcedures() {
        return procedures;
    }

    /**
     * @param animalID ID животного
     * @return список всех процедур, когда-либо выполненных в отношении конкретного животного
     */
    public ArrayList<IProcedure> getAnimalProceduresByID(int animalID) {
        ArrayList<IProcedure> result = new ArrayList<>();
        for (IProcedure procedure : procedures) {
            if (animalID == procedure.getAnimalID()) {
                result.add(procedure);
            }
        }
        return result;
    }

    /**
     *
     * @param animalID ID животного
     * @return список строк, которые содержат информацию о видах процедур, по которым уже наступил срок повторной обработки
     */
    public ArrayList<String> getAnimalNextProcedureByID(int animalID) {
        ArrayList<String> result = new ArrayList<>();
        String info = "";
        LocalDate today = LocalDate.now();
        for (IProcedure procedure : procedures) {
            if (procedure instanceof IRepeatableProcedure
                    && (today).compareTo(((IRepeatableProcedure) procedure).getDateOfNextProcedure()) >= 0) {
                info = procedure + "дата следующей обработки: " +
                        ((IRepeatableProcedure) procedure).getDateOfNextProcedure() + "\n";
                result.add(info);
            }
        }
        return result;
    }
}
