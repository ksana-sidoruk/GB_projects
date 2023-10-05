package org.example;

public class Answer {

    int countBull;
    int countCow;
    int maxTry;


    public Answer(int countBull, int countCow, int maxTry) {
        this.countBull = countBull;
        this.countCow = countCow;
        this.maxTry = maxTry;
    }

    @Override
    public String toString() {
        return "Количество быков: " + countBull +
                ", количество коров: " + countCow +
                ", осталось попыток: " + maxTry;
    }
}
