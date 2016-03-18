package com.iza.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anelson on 3/17/2016.
 */
public class Animal {
    private int id;
    private String name;
    private Species species;
    private List<AnimalFeedRecord> feedingRecords;

    public Animal(){
        feedingRecords = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<AnimalFeedRecord> getFeedingRecords() {
        return feedingRecords;
    }

    public void addFeedingRecord(AnimalFeedRecord animalFeedRecord){
        feedingRecords.add(animalFeedRecord);
    }
}
