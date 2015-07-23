package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class MItemPossessed {

    private long _id;
    private int numberOfItem;
    private long itemId;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getNumberOfItem() {
        return numberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        this.numberOfItem = numberOfItem;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long item) {
        this.itemId = item;
    }
}
