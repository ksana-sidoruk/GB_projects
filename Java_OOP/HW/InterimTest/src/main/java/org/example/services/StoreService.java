package org.example.services;

import org.example.data.PrizeToy;
import org.example.data.Toy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StoreService implements IStoreService {
    private PriorityQueue<Toy> toys = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<PrizeToy> prizePool = new LinkedList<>();

    @Override
    public void AddToy(Toy toy) {
        if (toy.count > 0) {
            toys.add(toy);
        } else {
            System.out.println("Нельзя добавить меньше одной игрушки");
        }
    }

    @Override
    public void UpdateCount(int id, int count) {
        for (Toy toy : toys
        ) {
            if (toy.id == id) {
                toy.count = count;
                break;
            }
        }
    }

    @Override
    public void UpdateWeight(int id, int weight) {
        for (Toy toy : toys
        ) {
            if (toy.id == id) {
                toy.weight = weight;
                break;
            }
        }
    }

    @Override
    public Toy GetToy() {
        if (!toys.isEmpty()) {
            return toys.poll();
        }
        return null;
    }

    @Override
    public void GeneratePrizePool(int count) {
        if (prizePool.isEmpty()) {
            for (int i = 0; i < count; i++) {
                var toy = toys.peek();

                if (toy != null) {
                    prizePool.add(new PrizeToy(toy.id, toy.name, toy.weight));
                    toy.count--;
                    if (toy.count == 0) {
                        toys.poll();
                    }
                }
            }
        } else {
            System.out.println("Призовой пул заполнен, раздайте игрушки перед тем, как формировать новый");
        }
    }

    @Override
    public PrizeToy ReleasePrizeToy() {
        if (!prizePool.isEmpty()) {
            return prizePool.poll();
        } else {
            System.out.println("Призовой пул пуст. Надо сгенерировать новый");
            return null;
        }
    }
}
