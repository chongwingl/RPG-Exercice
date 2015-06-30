package com.project.rpg.models.events;

/**
 * Created by laetitia on 6/30/15.
 */
public class UpdateSpecialStatEvent {

    private final int mSpecialStat;

    public UpdateSpecialStatEvent(final int specialStat) {
        mSpecialStat = specialStat;
    }

    public int getSpecialStat(){
        return mSpecialStat;
    }
}
