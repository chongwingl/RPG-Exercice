package com.project.rpg.engine.model;

/**
 * Created by laetitia on 7/16/15.
 */
public class Power {

    private long mId;
    private String name;
    private String description;
    private int minimumRound;
    private int maximumRound;
    private int percentOfEffect;
    private String statAffected;
    private int probabilityToHappen;
    private String effect;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
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

    public int getMinimumRound() {
        return minimumRound;
    }

    public void setMinimumRound(int minimumRound) {
        this.minimumRound = minimumRound;
    }

    public int getMaximumRound() {
        return maximumRound;
    }

    public void setMaximumRound(int maximumRound) {
        this.maximumRound = maximumRound;
    }

    public int getPercentOfEffect() {
        return percentOfEffect;
    }

    public void setPercentOfEffect(int percentOfEffect) {
        this.percentOfEffect = percentOfEffect;
    }

    public String getStatAffected() {
        return statAffected;
    }

    public void setStatAffected(String statAffected) {
        this.statAffected = statAffected;
    }

    public int getProbabilityToHappen() {
        return probabilityToHappen;
    }

    public void setProbabilityToHappen(int probabilityToHappen) {
        this.probabilityToHappen = probabilityToHappen;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
