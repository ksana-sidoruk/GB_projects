import java.util.Random;
public class Android implements Trailrunnable{
    private String name;
    private int runMax;
    private int jumpMax;
    protected static Random r = new Random();

    public Android(String name) {
        this.name = name;
        this.runMax = Android.r.nextInt(500, 1000);
        this.jumpMax = Android.r.nextInt(1, 5);
    }


    @Override
    public boolean run(Trail trail) {

        if (trail.getLength()>runMax){
            System.out.println("Робот " + name + " сломался пока бежал по " + trail.getName()
            + " длиной " + trail.getLength() + " м.");
            return false;
        }else {
            System.out.println("Робот " + name + " топает по "
                    + trail.getName() + " " + trail.getLength() + " м.");
            return true;
        }
    }

    @Override
    public boolean jump(Trunk trunk) {
        if (trunk.getHeight()>jumpMax){
            System.out.println("Робот " + name + " сломался, не перепрыгнув " + trunk.getName()
                    + " высотой " + trunk.getHeight() + " м.");
            return false;
        }else {
            System.out.println("Робот " + name + " перелетает "
                    + trunk.getName() + " высотой " + trunk.getHeight() + " м.");
            return true;
        }
    }


    @Override
    public String toString() {
        return "Робот " + name + ", максимальная длина бега: " +
                runMax + ", максимальная высота прыжка: " + jumpMax;
    }
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
