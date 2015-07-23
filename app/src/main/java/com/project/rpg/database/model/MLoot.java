package com.project.rpg.database.model;

/**
 * Created by laetitia on 7/16/15.
 */
public class MLoot {

    private long _id;
    private long monsterTypeId;
    private long itemId;

    public long getId() {
        return _id;
    }

    public void setId(long _id) {
        this._id = _id;
    }

    public long getMonsterTypeId() {
        return monsterTypeId;
    }

    public void setMonsterTypeId(long monsterTypeId) {
        this.monsterTypeId = monsterTypeId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
}
