package com.project.rpg.engine.model;

import com.project.rpg.exceptions.NotEnoughGoldException;

/**
 * Created by laetitia on 7/13/15.
 */
public class Gold {
    private int mGold;

    public Gold() {
        mGold = 0;
    }

    public Gold(int gold) {
        mGold = gold;
    }

    public int getGold() {
        return mGold;
    }

    public void addGold(int gold) {
        if (gold > 0) {
            this.mGold += gold;
        }
    }

    public void removeGold(int gold) throws NotEnoughGoldException {
        this.mGold -= gold;
        if (this.mGold <= 0) {
            this.mGold = 0;
            throw new NotEnoughGoldException();
        }
    }
}
