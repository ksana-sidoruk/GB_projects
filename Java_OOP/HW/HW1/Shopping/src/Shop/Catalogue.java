package Shop;
import java.util.ArrayList;

public class Catalogue {

    ArrayList<Category> categoriesList = new ArrayList<Category>();

    /**
     * @apiNote добавляет категорию в каталог
     * @param category
     */
    public void addCategory(Category category) {
        categoriesList.add(category);
    }

    /**
     * @apiNote выводит каталог товаров магазина по категориям. Если категория пуста - сообщает об этом
     */
    public void printCatalogue() {
        System.out.println("________________________________________" +
                "\nПеречень товаров магазина по категориям: ");
        for (Category category: categoriesList)
             System.out.println(category);
    }

}
