package org.example.data;

public class Dog extends Animal{
    public Dog(String name, String breed, int age) {
        super(name, breed, age);
    }

    @Override
    public String toString() {
        return "Собака: кличка - " + name +
                ", порода - " + breed +
                ", возраст (лет) - " + age;
    }
}
