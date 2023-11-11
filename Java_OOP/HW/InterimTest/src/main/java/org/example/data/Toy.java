package org.example.data;

public class Toy implements Comparable<Toy>{
    public Toy(int id, int weight, String name, int count) {
        this.id = id;
        this.weight = weight;
        this.name = name;
        this.count = count;
    }

    public int id;
    public int weight;
    public String name;
    public int count;

    @Override
    public int compareTo(Toy toCompare) {
        if(weight > toCompare.weight){
            return 1;
        } else if (weight < toCompare.weight) {
            return -1;
        }

        return 0;
    }
}
