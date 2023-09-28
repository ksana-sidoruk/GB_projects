package Shop;

import java.util.ArrayList;

public class Basket {

    ArrayList<Good> basket = new ArrayList<>();

    /**
     * @apiNote добавляет товар в корзину
     * @param good
     */
    protected void addGood(Good good){
        basket.add(good);
    }

    @Override
    public String toString() {
        return String.valueOf(basket);
    }
}

