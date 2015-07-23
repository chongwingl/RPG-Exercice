package com.project.rpg.engine.model;

/**
 * Created by laetitia on 7/13/15.
 */
public class CharacterStat {

    private static final int MAX_STAT = 20;

    private int mAccuracy = 0;
    private int mAgility = 0;
    private int mDexterity = 0;
    private int mResistance = 0;
    private int mSpeed = 0;
    private int mStrength = 0;

    public CharacterStat() {
    }

    public int getAccuracy() {
        return mAccuracy;
    }

    public void addAccuracy(int accuracy) {
        mAccuracy += accuracy;
        if (mAccuracy > MAX_STAT) {
            mAccuracy = MAX_STAT;
        }

    }

    public int getAgility() {
        return mAgility;
    }

    public void addAgility(int agility) {
        mAgility += agility;
        if (mAgility > MAX_STAT) {
            mAgility = MAX_STAT;
        }
    }

    public int getDexterity() {
        return mDexterity;
    }

    public void addDexterity(int dexterity) {
        mDexterity += dexterity;
        if (mDexterity > MAX_STAT) {
            mDexterity = MAX_STAT;
        }
    }

    public int getResistance() {
        return mResistance;
    }

    public void addResistance(int resistance) {
        mResistance += resistance;
        if (mResistance > MAX_STAT) {
            mResistance = MAX_STAT;
        }
    }

    public int getSpeed() {
        return mSpeed;
    }

    public void addSpeed(int speed) {
        mSpeed += speed;
        if (mSpeed > MAX_STAT) {
            mSpeed = MAX_STAT;
        }
    }

    public int getStrength() {
        return mStrength;
    }

    public void addStrength(int strength) {
        mStrength += strength;
        if (mStrength > MAX_STAT) {
            mStrength = MAX_STAT;
        }
    }
}
