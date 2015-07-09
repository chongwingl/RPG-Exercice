package com.project.rpg.models.items;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.enumerations.Weight;

import java.io.Serializable;

public abstract class AbstractItem implements Parcelable {

    private String mName;
    private int mPrice;
    private Weight mWeight; // used for calculate the speed of the knight( lighter
    // -> faster)
    protected ItemType mItemType;

    public AbstractItem() {
    }

    public AbstractItem(String name) {
        mName = name;
        setItemType();
        mWeight = Weight.NONE;
    }

    public String getName() {
        return mName;
    }

    public int getPrice() {
        return mPrice;
    }

    protected void setPrice(int price) {
        this.mPrice = price;
    }

    public Weight getWeight() {
        return mWeight;
    }

    protected void setWeight(Weight mWeight) {
        this.mWeight = mWeight;
    }

    public abstract Probability getProbabilityToFind();

    @Override
    public String toString() {
        return mName;
    }

    public ItemType getItemType() {
        return mItemType;
    }

    protected abstract void setItemType();

    public abstract void use(AbstractCharacter character);

    public abstract StringMessageDialogFragment getUseItemDialogFragment(Context context);

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(mName);
        out.writeInt(mPrice);
        out.writeSerializable(mWeight);
        out.writeSerializable(mItemType);
    }

    protected AbstractItem(Parcel in) {
        mName = in.readString();
        mPrice = in.readInt();
        mWeight = (Weight) in.readSerializable();
        mItemType = (ItemType) in.readSerializable();
    }
}
