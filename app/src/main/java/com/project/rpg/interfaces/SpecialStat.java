package com.project.rpg.interfaces;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by laetitia on 7/8/15.
 */
public interface SpecialStat extends Parcelable {

    int getSpecialStat();
    void setSpecialStat(int stat);

    int getSpecialMaxStat();
    void setSpecialMaxStat(int maxStat);

    int getSpecialStatIconId();

    @Override
    int describeContents();

    @Override
    void writeToParcel(Parcel dest, int flags);
}
