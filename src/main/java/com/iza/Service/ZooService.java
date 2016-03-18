package com.iza.Service;

import com.iza.Models.Zoo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anelson on 3/17/2016.
 *
 * This service should wire to the DAL, and use JPA to do our updates and queries, but
 * we're going to cheat and keep the data in memory
 *
 */
@Component
public class ZooService {

    private List<Zoo> zoos;


    public ZooService(){
        zoos = new ArrayList<>();
    }

    public Zoo addZoo(String name){

        Zoo zoo = new Zoo();
        zoo.setName(name);

        //yes, this would fall over with concurrency
        zoo.setId(zoos.size());
        zoos.add(zoo);

        return zoo;
    }

}
