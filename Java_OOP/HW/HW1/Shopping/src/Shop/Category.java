package Shop;

import java.util.ArrayList;

public class Category {
    protected String categoryName;
    protected ArrayList<Good> goods = new ArrayList<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @apiNote добавляет товар в категорию
     * @param good
     */
    protected void addGood(Good good){
        goods.add(good);
    }

    /**
     * @apiNote удаляет товар из категории
     * @param good
     */
    protected void removeGood(Good good){
        goods.remove(good);
    }

    @Override
    public String toString() {
        if (goods.isEmpty()){
            return "Категория \"" + categoryName + "\" сейчас пустует, но мы обязательно это исправим";
        } else {
            return "Категория \"" + categoryName + "\" содержит следующие товары: " + goods;
        }
    }
}
