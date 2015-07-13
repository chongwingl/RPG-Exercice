package com.project.rpg.engine.model;

/**
 * Created by laetitia on 7/13/15.
 */
public class Item {
    private String mName;
    private String mDescription;
    private String mItemType;
    private String mItemSubType;
    private int mPrice;
    private String mPower;
    private String mSlot;
    private String mProbability;

    public Item() {
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String mItemType) {
        this.mItemType = mItemType;
    }

    public String getItemSubType() {
        return mItemSubType;
    }

    public void setItemSubType(String mItemSubType) {
        this.mItemSubType = mItemSubType;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public String getPower() {
        return mPower;
    }

    public void setPower(String mPower) {
        this.mPower = mPower;
    }

    public String getSlot() {
        return mSlot;
    }

    public void setSlot(String mSlot) {
        this.mSlot = mSlot;
    }

    public String getProbability() {
        return mProbability;
    }

    public void setProbability(String mProbability) {
        this.mProbability = mProbability;
    }
}
