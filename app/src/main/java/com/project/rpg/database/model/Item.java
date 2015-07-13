package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/9/15.
 */
public class Item {

    private ItemType itemType;
    private ItemSubtype itemSubtype;
    private String name;
    private String description;
    private int price;
    private Power power;
    private Slot slot;
    private Probability probabilityToFind;

    public Item() {
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

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemSubtype getItemSubtype() {
        return itemSubtype;
    }

    public void setItemSubtype(ItemSubtype itemSubtype) {
        this.itemSubtype = itemSubtype;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public Probability getProbabilityToFind() {
        return probabilityToFind;
    }

    public void setProbabilityToFind(Probability probabilityToFind) {
        this.probabilityToFind = probabilityToFind;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
