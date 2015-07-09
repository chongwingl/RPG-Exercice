package com.project.rpg.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.CharacterState;
import com.project.rpg.models.powers.Life;

import java.io.Serializable;

public class Stat implements Parcelable {
    public static final int MAX_STAT = 200;

    private LifePoint mLifePoints;
    private int mStrength;
    private int mSpeed;
    private int mAccuracy;
    private int mResistance;
    private CharacterState mState = CharacterState.NOR;

    public Stat() {
    }

    public Stat(int maxLifePoints) {
        mLifePoints = new LifePoint(maxLifePoints);
    }

    public Stat(int maxLifePoints, int strength, int speed, int accuracy, int resistance) {
        mLifePoints = new LifePoint(maxLifePoints);
        mStrength = strength;
        mSpeed = speed;
        mAccuracy = accuracy;
        mResistance = resistance;
    }

    public int getStrength() {
        return mStrength;
    }
    public void addStrength(int add) {
        mStrength += add;
    }

    public void setStrength(int strength) {
        if (strength < MAX_STAT) {
            mStrength = strength;
        } else {
            mStrength = MAX_STAT;
        }
    }

    public int getSpeed() {
        return mSpeed;
    }

    public void addSpeed(int add) {
        mSpeed += add;
    }

    public void setSpeed(int speed) {
        if (speed < MAX_STAT) {
            mSpeed = speed;
        } else {
            mSpeed = MAX_STAT;
        }
    }

    public LifePoint getLifePoints() {
        return mLifePoints;
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public void addAccuracy(int add) {
        mAccuracy += add;
    }

    public void setAccuracy(int accuracy) {
        if (accuracy < MAX_STAT) {
            mAccuracy = accuracy;
        } else {
            mAccuracy = MAX_STAT;
        }
    }

    public int getResistance() {
        return mResistance;
    }

    public void addResistance(int add) {
        mResistance += add;
    }

    public void setResistance(int resistance) {
        if (resistance < MAX_STAT) {
            mResistance = resistance;
        } else {
            mResistance = MAX_STAT;
        }
    }

    public CharacterState getState() {
        return mState;
    }

    public void setState(CharacterState state) {
        this.mState = state;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(mLifePoints, flags);
        out.writeSerializable(mState);
        out.writeInt(mStrength);
        out.writeInt(mResistance);
        out.writeInt(mSpeed);
        out.writeInt(mAccuracy);
    }

    public static final Parcelable.Creator<Stat> CREATOR
            = new Parcelable.Creator<Stat>() {
        public Stat createFromParcel(Parcel in) {
            return new Stat(in);
        }

        public Stat[] newArray(int size) {
            return new Stat[size];
        }
    };

    private Stat(Parcel in) {
        mLifePoints = in.readParcelable(LifePoint.class.getClassLoader());
        mState = (CharacterState) in.readSerializable();
        mStrength = in.readInt();
        mResistance = in.readInt();
        mSpeed = in.readInt();
        mAccuracy = in.readInt();
    }
}
