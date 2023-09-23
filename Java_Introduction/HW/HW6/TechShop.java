import java.util.*;

import static java.lang.System.in;

public class TechShop {
    private Set<NoteBook> notebooks = new HashSet<>();
/**
 * @apiNote добавляет экземпляр класса ноутбук в магазин (множество ноутбуков)
 * @param notebook экземпляр класса нотбук
 */
    public void addNotebook(NoteBook notebook) {
        notebooks.add(notebook);
    }
/**
 * @apiNote позволяет вывести все ноуты, находящиеся в магазине (множестве ноутбуков)
 * @return ноутбуки, добавленные в магазин, списком
 */
    public ArrayList<NoteBook> getNotebooks() {
        return new ArrayList<>(notebooks);
    }
/**
 * 
 * @return словарь, содержащий критерии поиска, заданные пользователем с клавиатуры
 */
    public Map<String, String> getCriteria() {
        Map<String, String> criteria = new HashMap<String, String>();
        Scanner scanner = new Scanner(in);
        while (true) {
            System.out.println("Введите цифру, соответствующую необходимому критерию, где: \n1 - модель ноутбука" +
                    "\n2 - ОЗУ \n3 - объем ЖД \n4 - операционная система \n5 - цвет " +
                    "\nвведите 0, когда закончите добавлять критерии");
            String num = scanner.nextLine();
            if (Integer.parseInt(num) == 0) {
                scanner.close();
                return criteria;
            }
            System.out.println("Введите параметр");
            String criterion = scanner.nextLine();
            criteria.put(num, criterion);
        }
    }

    /**
     * @apiNote добавляет в список ноутбуки, соответствующие критериям поиска
     * @param словарь с критериями, полученный при помощи метода getCriteria()
     * @return список ноутбуков, подходящих под заданные критерии
     */
    public ArrayList<NoteBook> getFilteredNotebooks(Map<String, String> criteria) {
        ArrayList<NoteBook> result = new ArrayList<>();
        Iterator<NoteBook> iterator = notebooks.iterator();
        String modelCriteria = criteria.get("1");
        String ram = criteria.get("2");
        Integer ramCriteria = null;
        if (ram != null) {
            ramCriteria = Integer.parseInt(ram);
        }
        String memory = criteria.get("3");
        Integer memoryCriteria = null;
        if (memory != null) {
            memoryCriteria = Integer.parseInt(memory);
        }
        OS osCriteria = null;
        String os = criteria.get("4");
        if (os!= null){
            osCriteria = OS.valueOf(os);
        }
        String colorCriteria = criteria.get("5");


        while (iterator.hasNext()) {
            NoteBook notebook = iterator.next();
            if (modelCriteria != null && !notebook.model.equals(modelCriteria)) {
                continue;
            }
            if (ramCriteria != null && notebook.ramSize < ramCriteria) {
                continue;
            }
            if (memoryCriteria != null && notebook.memorySize < memoryCriteria) {
                continue;
            }
            if (colorCriteria != null && !notebook.color.equals(colorCriteria)) {
                continue;
            }
            if (osCriteria != null && !notebook.operationSystem.equals(osCriteria)) {
                continue;
            }

            result.add(notebook);
        }
        return result;
    }
}