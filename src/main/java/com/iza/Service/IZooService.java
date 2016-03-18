package com.iza.Service;

import com.iza.DTO.DailyFeedingDTO;
import com.iza.Models.*;

import java.util.Date;
import java.util.List;

/**
 * Created by anelson on 3/17/2016.
 */
public interface IZooService {
    Zoo addZoo(String name);
    Species addSpecies(String name);
    Animal addAnimal(String name, Species species, Zoo zoo);
    Feed addFeed(String name);
    AnimalFeedRecord addFeedRecord(Animal animal, Feed feed, double amount, Date day);

    List<DailyFeedingDTO> getAnimalFeedingHistory(Zoo zoo, int animalId);
}
