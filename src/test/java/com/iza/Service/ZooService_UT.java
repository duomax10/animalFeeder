package com.iza.Service;

import com.iza.DTO.DailyFeedingDTO;
import com.iza.Models.Animal;
import com.iza.Models.Feed;
import com.iza.Models.Species;
import com.iza.Models.Zoo;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by anelson on 3/17/2016.
 */
public class ZooService_UT {

    private IZooService zooService = new ZooService();

    @Test
    public void getFeedRecord(){
        Zoo hogleZoo = zooService.addZoo("Hogle Zoo");
        Species lion = zooService.addSpecies("Lion");
        Animal simba = zooService.addAnimal("Simba", lion, hogleZoo);
        Feed antelope = zooService.addFeed("antelope");
        zooService.addFeedRecord(simba, antelope, 1.0, new Date());

        List<DailyFeedingDTO> animalFeedingHistory = zooService.getAnimalFeedingHistory(hogleZoo, simba.getId());
        Assert.assertNotNull(animalFeedingHistory);
        Assert.assertEquals(1, animalFeedingHistory.size());

        DailyFeedingDTO dailyFeedingDTO = animalFeedingHistory.get(0);
        Assert.assertEquals(1, dailyFeedingDTO.getFeedList().size());
    }
}
