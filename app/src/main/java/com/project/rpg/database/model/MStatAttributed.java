package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/16/15.
 */
public class MStatAttributed {

    private long _id;
    private int value;
    private long itemId;
    private long statId;
    private long characterId;
    private long monsterId;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getStatId() {
        return statId;
    }

    public void setStatId(long statId) {
        this.statId = statId;
    }

    public long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public long getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(long monsterId) {
        this.monsterId = monsterId;
    }
}
