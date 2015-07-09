package com.project.rpg.models.items.material;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.AbstractItem;


public abstract class AbstractMaterial extends AbstractItem {

    private int mGatherTime;
    private Probability mProbabilityToFind;

    public AbstractMaterial() {
    }

    protected AbstractMaterial(String name, Probability probability) {
        super(name);
        mProbabilityToFind = probability;
    }

    public int getGatherTime() {
        return mGatherTime;
    }

    protected void setGatherTime(int mGatherTime) {
        this.mGatherTime = mGatherTime;
    }

    @Override
    protected void setItemType() {
        mItemType = ItemType.MATERIAL;
    }

    @Override
    public void use(AbstractCharacter character) {

    }

    @Override
    public Probability getProbabilityToFind() {
        return mProbabilityToFind;
    }

    @Override
    public StringMessageDialogFragment getUseItemDialogFragment(Context context) {
        return null;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(mGatherTime);
        out.writeSerializable(mProbabilityToFind);
    }

    protected AbstractMaterial(Parcel in) {
        super(in);
        mGatherTime = in.readInt();
        mProbabilityToFind = (Probability) in.readSerializable();
    }
}
