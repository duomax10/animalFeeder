package com.iza.Models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by anelson on 3/17/2016.
 */
public class AnimalFeedRecord{
    private Date day;
    private Feed feed;
    private double amount;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
