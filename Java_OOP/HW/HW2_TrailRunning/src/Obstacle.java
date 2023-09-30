import java.util.Random;
public class Obstacle {
    protected String name;
    protected static Random r = new Random();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
