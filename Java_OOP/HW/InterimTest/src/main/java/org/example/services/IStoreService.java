package org.example.services;

import org.example.data.PrizeToy;
import org.example.data.Toy;

public interface IStoreService {
    void AddToy(Toy toy);

    void UpdateCount(int id, int count);

    void UpdateWeight(int id, int weight);

    Toy GetToy();

    void GeneratePrizePool(int count);

    PrizeToy ReleasePrizeToy();
}
