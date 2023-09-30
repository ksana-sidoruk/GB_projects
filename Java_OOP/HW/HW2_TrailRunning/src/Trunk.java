
public class Trunk extends Obstacle{

    protected int height;

    protected String[] names = {
            "бревно",
            "упавшее дерево",
            "труп поверженного врага",
            "неопознанный объект"};

    public Trunk() {
        super.name = names[Trail.r.nextInt(0, 3)];
        this.height = Trail.r.nextInt(1, 6);
    }

    public int getHeight() {
        return height;
    }
    protected void setHeight(int height) {
        this.height = height;
    }
}
