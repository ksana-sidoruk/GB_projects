public class Human extends Mammal{
    public Human (String name) {
        this.name = name;
        this.runMax = Mammal.r.nextInt(1, 800);
        this.jumpMax = Mammal.r.nextInt(1, 6);
    }

    @Override
    public boolean run(Trail trail) {
        if (trail.getLength()>runMax){
            System.out.println("Человек " + name + " выдыхается, не пробежав "
                    + trail.getLength() + " м. по " + trail.getName());
            return false;
        }else {
            System.out.println("Человек " + name + " трусит по "
                    + trail.getName() + " " + trail.getLength() + " м.");
            return true;
        }
    }

    @Override
    public boolean jump(Trunk trunk) {
        if (trunk.getHeight() > jumpMax) {
            System.out.println("Человек " + name + " не может перепрыгнуть " + trunk.getName()
                    + " высотой " + trunk.getHeight() + " м.");
            return false;
        } else {
            System.out.println("Человек " + name + " перепрыгивает "
                    + trunk.getName() + " высотой " + trunk.getHeight() + " м.");
            return true;

        }
    }

    @Override
    public String toString() {
        return "Человек " + name + ", максимальная длина бега: " +
                runMax + ", максимальная высота прыжка: " + jumpMax;
    }
}
