package com.project.rpg.models.events;

/**
 * Created by laetitia on 6/30/15.
 */
public class UpdateSpecialStatEvent {

    private final int mSpecialStat;
    private final int mSpecialMaxStat;

    public UpdateSpecialStatEvent(final int specialStat, final int specialMaxStat) {
        mSpecialStat = specialStat;
        mSpecialMaxStat = specialMaxStat;
    }

    public int getSpecialStat(){
        return mSpecialStat;
    }

    public int getSpecialMaxStat() {
        return mSpecialMaxStat;
    }
}
