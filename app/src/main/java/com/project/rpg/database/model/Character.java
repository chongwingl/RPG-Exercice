package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class Character {

    private String name;
    private int gold;
    private Class clss;
    private Level level;
    private Power power;

    public Character() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public Class getClss() {
        return clss;
    }

    public void setClss(Class clss) {
        this.clss = clss;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Power getPower() {
        return power;
    }

    public void setPower(Power power) {
        this.power = power;
    }
}
