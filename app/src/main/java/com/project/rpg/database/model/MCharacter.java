package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class MCharacter {

    private long _id;
    private String name;
    private int gold;
    private long levelId;
    private long powerId = 0;
    private int life;
    private int maxLife;

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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long level) {
        this.levelId = level;
    }

    public long getPowerId() {
        return powerId;
    }

    public void setPowerId(long power) {
        this.powerId = power;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }
}
