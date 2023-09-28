package Shop;

public class Good {

    protected String goodName;
    protected Category category;
    protected Double rating;
    protected int price;


    public Good(String goodName, Category category, int price) {
        this.goodName = goodName;
        this.category = category;
        this.price = price;
        this.category.addGood(this);
    }

    @Override
    public String toString() {
        return goodName + " (" + price +" gold)";
    }

    public Category getCategory() {
        return category;
    }

    public Double getRating() {
        return rating;
    }
}
