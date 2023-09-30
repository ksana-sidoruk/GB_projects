import java.util.Random;

public abstract class Mammal implements Trailrunnable {
    protected String name;
    protected int runMax;
    protected int jumpMax;
    protected static Random r = new Random();

    @Override
    public abstract boolean run(Trail trail);

    @Override
    public abstract boolean jump(Trunk trunk);

    public String getName() {
        return name;
    }
    protected void setName(String name) {
        this.name = name;
    }
    public int getRunMax() {
        return runMax;
    }
    protected void setRunMax(int runMax) {
        this.runMax = runMax;
    }
    public int getJumpMax() {
        return jumpMax;
    }
    protected void setJumpMax(int jumpMax) {
        this.jumpMax = jumpMax;
    }
}

