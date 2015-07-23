package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/16/15.
 */
public class MEquipped {

    private long _id;
    private long characterId;
    private long itemPossessedId;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public long getItemPossessedId() {
        return itemPossessedId;
    }

    public void setItemPossessedId(long itemPossessedId) {
        this.itemPossessedId = itemPossessedId;
    }
}
