package com.project.rpg.database.model;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/9/15.
 */
public class Power {
    private String name;
    private String description;
    private int minimumRound;
    private int manimumRound;
    private int percentOfEffect;
    private Probability probabilityToHappen;

    public Power() {
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

    public int getManimumRound() {
        return manimumRound;
    }

    public void setManimumRound(int manimumRound) {
        this.manimumRound = manimumRound;
    }

    public int getPercentOfEffect() {
        return percentOfEffect;
    }

    public void setPercentOfEffect(int percentOfEffect) {
        this.percentOfEffect = percentOfEffect;
    }

    public Probability getProbabilityToHappen() {
        return probabilityToHappen;
    }

    public void setProbabilityToHappen(Probability probabilityToHappen) {
        this.probabilityToHappen = probabilityToHappen;
    }
}
