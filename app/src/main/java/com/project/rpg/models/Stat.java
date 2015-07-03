package com.project.rpg.models;

import com.project.rpg.models.enumerations.CharacterState;

import java.io.Serializable;

public class Stat implements Serializable {
    private static final long serialVersionUID = 3012347748078701155L;
    public static final int MAX_STAT = 200;

    private LifePoint mLifePoints;
    private int mStrength;
    private int mSpeed;
    private int mAccuracy;
    private int mResistance;
    private CharacterState mState = CharacterState.NOR;

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

    public void addResisteance(int add) {
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
}
