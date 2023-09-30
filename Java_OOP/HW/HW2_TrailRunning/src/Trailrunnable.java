public interface Trailrunnable {

    /**
     * @apiNote метод интерфейса заставляет экземпляр класса бежать
     * @param trail препятствие, которое надо преодолеть бегом
     * @return true, если удалось преодолеть препятствие бегом, false, если не удалось
     */
    boolean run(Trail trail);

    /**
     * @apiNote метод интерфейса заставляет экземпляр класса прыгать
     * @param trunk препятствие, которое надо преодолеть прыжком
     * @return true, если удалось преодолеть препятствие прыжком, false, если не удалось
     */
    boolean jump(Trunk trunk);

}
