package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/10/15.
 */
public class MMonster {

    private long _id;
    private long typeId;
    private long levelId;
    private long powerId;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getLevelId() {
        return levelId;
    }

    public void setLevelId(long levelId) {
        this.levelId = levelId;
    }

    public long getPowerId() {
        return powerId;
    }

    public void setPowerId(long powerId) {
        this.powerId = powerId;
    }
}
