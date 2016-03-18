package com.iza.Models;

/**
 * Created by anelson on 3/17/2016.
 */
public class FeedInventory {
    private int id;
    private Feed feed;
    private double amount;
    private Zoo zoo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
