package com.project.rpg.database.model;

import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/9/15.
 */
public class Item {

    private ItemType itemType;
    private String name;
    private String description;
    private int price;
    private int weight;
    private int strength;
    private int accuracy;
    private int resistance;
    private int partOfBody;
    private Power power;
    private int lifePoints;
    private Probability probabilityToFind;

    public Item() {
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getPartOfBody() {
        return partOfBody;
    }

    public void setPartOfBody(int partOfBody) {
        this.partOfBody = partOfBody;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Probability getProbabilityToFind() {
        return probabilityToFind;
    }

    public void setProbabilityToFind(Probability probabilityToFind) {
        this.probabilityToFind = probabilityToFind;
    }
}
