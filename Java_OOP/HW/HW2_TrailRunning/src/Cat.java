public class Cat extends Mammal {
    public Cat(String name) {
        this.name = name;
        this.runMax = Mammal.r.nextInt(1, 350);
        this.jumpMax = Mammal.r.nextInt(1, 10);
    }

    @Override
    public boolean run(Trail trail) {
        if (trail.getLength()>runMax){
            System.out.println("Кот " + name + " решил, что ему незачем бежать  "
                    + trail.getLength() + " м. по " + trail.getName());
            return false;
        }else {
            System.out.println("Кот " + name + " делает тыгдык-тыгдык по "
                    + trail.getName() + " " + trail.getLength() + " м.");
            return true;
        }
    }
    @Override
    public boolean jump(Trunk trunk) {
        if (trunk.getHeight() > jumpMax) {
            System.out.println("Кот " + name + " врезался в " + trunk.getName()
                    + " высотой " + trunk.getHeight() + " м.");
            return false;
        } else {
            System.out.println("Кот " + name + " перепрыгивает "
                    + trunk.getName() + " высотой " + trunk.getHeight() + " м.");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Кот " + name + ", максимальная длина бега: " +
                runMax + ", максимальная высота прыжка: " + jumpMax;
    }
}
