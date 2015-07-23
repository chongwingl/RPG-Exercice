package com.project.rpg.engine.model;

/**
 * Created by laetitia on 7/13/15.
 */
public class Item {
    private long mId;
    private String mName;
    private String mDescription;
    private String mItemType;
    private String mItemSubType;
    private int mPrice;
    private String mPower;
    private String mSlot;
    private int mProbability;
    private int mNumberOfItem;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        this.mId = id;
    }

    public Item() {
        mNumberOfItem = 0;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getItemType() {
        return mItemType;
    }

    public void setItemType(String itemType) {
        mItemType = itemType;
    }

    public String getItemSubType() {
        return mItemSubType;
    }

    public void setItemSubType(String itemSubType) {
        mItemSubType = itemSubType;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }

    public String getPower() {
        return mPower;
    }

    public void setPower(String power) {
        mPower = power;
    }

    public String getSlot() {
        return mSlot;
    }

    public void setSlot(String slot) {
        mSlot = slot;
    }

    public int getProbability() {
        return mProbability;
    }

    public void setProbability(int probability) {
        mProbability = probability;
    }

    public int getNumberOfItem() {
        return mNumberOfItem;
    }

    public void setNumberOfItem(int numberOfItem) {
        mNumberOfItem = numberOfItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (mPrice != item.mPrice) return false;
        if (mProbability != item.mProbability) return false;
        if (!mName.equals(item.mName)) return false;
        if (mDescription != null ? !mDescription.equals(item.mDescription) : item.mDescription != null)
            return false;
        if (!mItemType.equals(item.mItemType)) return false;
        if (mItemSubType != null ? !mItemSubType.equals(item.mItemSubType) : item.mItemSubType != null)
            return false;
        if (mPower != null ? !mPower.equals(item.mPower) : item.mPower != null) return false;
        return mSlot.equals(item.mSlot);

    }

    @Override
    public int hashCode() {
        int result = mName.hashCode();
        result = 31 * result + (mDescription != null ? mDescription.hashCode() : 0);
        result = 31 * result + mItemType.hashCode();
        result = 31 * result + (mItemSubType != null ? mItemSubType.hashCode() : 0);
        result = 31 * result + mPrice;
        result = 31 * result + (mPower != null ? mPower.hashCode() : 0);
        result = 31 * result + mSlot.hashCode();
        result = 31 * result + mProbability;
        return result;
    }
}
