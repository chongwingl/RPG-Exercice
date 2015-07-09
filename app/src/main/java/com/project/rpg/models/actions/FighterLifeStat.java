package com.project.rpg.models.actions;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.interfaces.SpecialStat;

/**
 * Created by laetitia on 7/8/15.
 */
public class FighterLifeStat implements SpecialStat {

    private int mStat;
    private int mMaxStat;
    private int mIconRefId;

    public FighterLifeStat(int stat, int maxStat, int iconRefId) {
        this.mStat = stat;
        this.mMaxStat = maxStat;
        this.mIconRefId = iconRefId;
    }

    @Override
    public void setSpecialStat(int stat) {
        this.mStat = stat;
    }

    @Override
    public void setSpecialMaxStat(int maxStat) {
        this.mMaxStat = maxStat;
    }

    @Override
    public int getSpecialStat() {
        return mStat;
    }

    @Override
    public int getSpecialMaxStat() {
        return mMaxStat;
    }

    @Override
    public int getSpecialStatIconId() {
        return mIconRefId;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mStat);
        out.writeInt(mMaxStat);
        out.writeInt(mIconRefId);
    }

    public static final Parcelable.Creator<FighterLifeStat> CREATOR
            = new Parcelable.Creator<FighterLifeStat>() {
        public FighterLifeStat createFromParcel(Parcel in) {
            return new FighterLifeStat(in);
        }

        public FighterLifeStat[] newArray(int size) {
            return new FighterLifeStat[size];
        }
    };

    private FighterLifeStat(Parcel in) {
        mStat = in.readInt();
        mMaxStat = in.readInt();
        mIconRefId = in.readInt();
    }
}
