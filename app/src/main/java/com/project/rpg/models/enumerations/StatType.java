package com.project.rpg.models.enumerations;

import android.content.Context;

import com.project.rpg.R;

/**
 * Created by laetitia on 7/3/15.
 */
public enum StatType {
    STRENGTH(R.string.strength),
    SPEED(R.string.speed),
    ACCURACY(R.string.accuracy),
    RESISTANCE(R.string.resistance);

    private int mRefId;

    StatType(int refId) {
        mRefId = refId;
    }

    public int getRefId() {
        return mRefId;
    }

    public static StatType getStatTypeByName(Context context, String name) {
        for (StatType statType : values()) {
            if (context.getString(statType.getRefId()).equals(name)) {
                return statType;
            }
        }
        return null;
    }
}
