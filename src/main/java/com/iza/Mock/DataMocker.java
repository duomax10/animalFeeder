package com.iza.Mock;

import com.iza.Models.*;
import com.iza.Service.IZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by anelson on 3/17/2016.
 * There is WAYYYYY too much to even get a functional web service stubbed out we need
 * Create zoos
 * Create feeds
 * Create species
 * Create animals
 * Create some data so the endpoints are meaningful
 *
 * We could create SQL scripts that do all of these, but I don't know if I'll even have time to
 * create the schema and wire it up through JPA, so, we're going to cheat and make some data
 */
@Component
public class DataMocker {

    IZooService zooService;

    @Autowired
    public DataMocker(IZooService zooService){
        this.zooService = zooService;
    }

    @PostConstruct
    public void mockData(){
        Zoo hogleZoo = zooService.addZoo("Hogle Zoo");
        Species lion = zooService.addSpecies("Lion");
        Animal simba = zooService.addAnimal("Simba", lion, hogleZoo);
        Feed antelope = zooService.addFeed("antelope");
        zooService.addFeedRecord(simba, antelope, 1.0, new Date());
    }

}
