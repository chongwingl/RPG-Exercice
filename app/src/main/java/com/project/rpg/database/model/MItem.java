package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/9/15.
 */
public class MItem {

    private long _id;
    private String itemType;
    private String itemSubtype;
    private String name;
    private String description;
    private int price;
    private long powerId;
    private String slot;
    private int probabilityToFind;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemSubtype() {
        return itemSubtype;
    }

    public void setItemSubtype(String itemSubtype) {
        this.itemSubtype = itemSubtype;
    }

    public long getPowerId() {
        return powerId;
    }

    public void setPowerId(long power) {
        this.powerId = power;
    }

    public int getProbabilityToFind() {
        return probabilityToFind;
    }

    public void setProbabilityToFind(int probabilityToFind) {
        this.probabilityToFind = probabilityToFind;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
