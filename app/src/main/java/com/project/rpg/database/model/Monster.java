package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class Monster {

    private MonsterType type;
    private Level level;
    private Power power;

    public Monster() {
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
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
