package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class ItemPossessed {

    private int numberOfItem;
    private Item item;

    public ItemPossessed() {
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
