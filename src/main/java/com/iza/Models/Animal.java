package com.iza.Models;

/**
 * Created by anelson on 3/17/2016.
 */
public class Animal {
    private int id;
    private String name;
    private Species species;

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
}
