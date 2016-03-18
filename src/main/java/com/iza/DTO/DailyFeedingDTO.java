package com.iza.DTO;

import com.iza.Models.Feed;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by anelson on 3/17/2016.
 */
public class DailyFeedingDTO {
    private Date date;
    private List<Pair<String, Double>> feedList;

    public DailyFeedingDTO(){
        setFeedList(new ArrayList<>());
    }

    public List<Pair<String, Double>> getFeedList() {
        return feedList;
    }

    public void setFeedList(List<Pair<String, Double>> feedList) {
        this.feedList = feedList;
    }

    public void addFeeding(String feedName, Double amount){
        Pair<String, Double> of = Pair.of(feedName, amount);
        feedList.add(of);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
