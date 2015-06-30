package com.project.rpg.models.events;

/**
 * Created by laetitia on 6/30/15.
 */
public class UpdateGoldEvent {

    private final int mGold;

    public UpdateGoldEvent(final int gold) {
        mGold = gold;
    }

    public int getGold(){
        return mGold;
    }
}
