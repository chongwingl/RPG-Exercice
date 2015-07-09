package com.project.rpg.models.items.weapons;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.powers.AbstractPower;

public abstract class AbstractWeapon extends AbstractItem {

    protected Strength mStrength;
    protected Accuracy mAccuracy;
    protected AbstractPower mPower;

    public AbstractWeapon() {
    }

    protected AbstractWeapon(String name) {
        super(name);
    }

    public Strength getStrength() {
        return mStrength;
    }

    protected void setStrength(Strength strength) {
        this.mStrength = strength;
    }

    public Accuracy getAccuracy() {
        return mAccuracy;
    }

    protected void setAccuracy(Accuracy accuracy) {
        this.mAccuracy = accuracy;
    }

    public AbstractPower getPower() {
        return mPower;
    }

    protected void setPower(AbstractPower mPower) {
        this.mPower = mPower;
    }

    @Override
    protected void setItemType() {
        mItemType = ItemType.WEAPON;
    }

    @Override
    public void use(AbstractCharacter character) {

    }

    @Override
    public StringMessageDialogFragment getUseItemDialogFragment(Context context) {
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(mPower, flags);
        out.writeSerializable(mStrength);
        out.writeSerializable(mAccuracy);
    }

    protected AbstractWeapon(Parcel in) {
        super(in);
        mPower = in.readParcelable(mPower.getClass().getClassLoader());
        mStrength = (Strength) in.readSerializable();
        mAccuracy = (Accuracy) in.readSerializable();
    }
}
