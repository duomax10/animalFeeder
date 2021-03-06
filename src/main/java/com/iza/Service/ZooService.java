package com.iza.Service;

import com.iza.DTO.DailyFeedingDTO;
import com.iza.Models.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by anelson on 3/17/2016.
 *
 * This service should wire to the DAL, and use JPA to do our updates and queries, but
 * we're going to cheat and keep the data in memory
 *
 */
@Component
public class ZooService implements IZooService {

    private List<Zoo> zoos;
    //Species is both plural and singular, that's fun
    private List<Species> speciesList;
    private List<Animal> animals;
    private List<Feed> feeds;
    private List<AnimalFeedRecord> animalFeedRecords;


    public ZooService(){
        zoos = new ArrayList<>();
        speciesList = new ArrayList<>();
        animals = new ArrayList<>();
        feeds = new ArrayList<>();
        animalFeedRecords = new ArrayList<>();
    }


    @Override
    public Zoo addZoo(String name){
        Zoo zoo = new Zoo();
        zoo.setName(name);

        //yes, this would fall over with concurrency
        zoo.setId(zoos.size());
        zoos.add(zoo);
        return zoo;
    }


    @Override
    public Species addSpecies(String name){
        Species species = new Species();
        species.setName(name);
        species.setId(speciesList.size());
        speciesList.add(species);
        return species;
    }


    @Override
    public Animal addAnimal(String name, Species species, Zoo zoo){
        Animal animal = new Animal();
        animal.setName(name);
        animal.setSpecies(species);
        animal.setId(animals.size());
        animals.add(animal);

        zoo.addAnimal(animal);
        return animal;
    }

    @Override
    public Feed addFeed(String name) {
        Feed feed = new Feed();
        feed.setName(name);
        feed.setId(feeds.size());
        return feed;
    }

    @Override
    public AnimalFeedRecord addFeedRecord(Animal animal, Feed feed, double amount, Date day) {
        AnimalFeedRecord animalFeedRecord = new AnimalFeedRecord();
        animalFeedRecord.setFeed(feed);
        animalFeedRecord.setAmount(amount);
        animalFeedRecord.setDay(day);
        animal.addFeedingRecord(animalFeedRecord);
        return animalFeedRecord;
    }

    @Override
    public List<DailyFeedingDTO> getAnimalFeedingHistory(Zoo zoo, int animalId) {
        Optional<Animal> first = zoo.getAnimals().stream().filter(a -> a.getId() == animalId).findFirst();

        List<DailyFeedingDTO> feedings = null;

        if(first.isPresent()){
            Animal animal = first.get();
            //this should do a group by and get all feeds for a day and turn them all into a DailyFeedingDTO, but we're out of time
            feedings = animal.getFeedingRecords().stream().map(fr -> {
                DailyFeedingDTO dailyFeeding = new DailyFeedingDTO();
                dailyFeeding.addFeeding(fr.getFeed().getName(), fr.getAmount());

                return dailyFeeding;
            }).collect(Collectors.toList());
        }

        return feedings;
    }

}
