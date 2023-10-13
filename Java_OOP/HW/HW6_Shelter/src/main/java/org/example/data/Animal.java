package org.example.data;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Animal {
    protected int animalID;
    protected String name;
    protected String breed;
    protected int age;


    public Animal(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }


}
