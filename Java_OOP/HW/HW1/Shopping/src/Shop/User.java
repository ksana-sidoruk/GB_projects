package Shop;

public class User {

    private String login;
    private String password;
    private Basket basket = new Basket();


    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * @param good
     * @apiNote метод удаляет товар из категории каталога магазина и добавляет в корзину покупателя
     */
    public void buysGood(Good good) {
        good.getCategory().removeGood(good);
        basket.addGood(good);
        System.out.println(login + " купил(а) " + good);
    }

    /**
     * @apiNote позволяет выставить рейтинг товару (от 1 до 5),
     * если рейтинга еще нет, либо пересчитать существующий
     * @param good
     * @param ratingNumber
     */
    public void rateGood(Good good, Integer ratingNumber) {
        if (ratingNumber > 5 || ratingNumber < 1){
            System.out.println("Для выставления рейтинга выберите цифру от 1 до 5");
        }
        if (good.getRating() == null){
            good.rating = ratingNumber.doubleValue();
        } else{
            good.rating = (good.rating + ratingNumber.doubleValue()) / 2;
        }
        System.out.println("Спасибо за вашу оценку, теперь рейтинг " + good + ": " + good.rating);
    }

    @Override
    public String toString() {
        return "Покупатель " + login + " прикупил(а) в магазине: " + basket;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
