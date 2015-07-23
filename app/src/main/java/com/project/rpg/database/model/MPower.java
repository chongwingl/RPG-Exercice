package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/9/15.
 */
public class MPower {
    private long _id;
    private String name;
    private String description;
    private int minimumRound;
    private int maximumRound;
    private int percentOfEffect;
    private long statAffectedId;
    private int probabilityToHappen;
    private String effect;

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

    public int getProbabilityToHappen() {
        return probabilityToHappen;
    }

    public void setProbabilityToHappen(int probabilityToHappen) {
        this.probabilityToHappen = probabilityToHappen;
    }

    public long getStatAffectedId() {
        return statAffectedId;
    }

    public void setStatAffectedId(long statAffectedId) {
        this.statAffectedId = statAffectedId;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
