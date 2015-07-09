package com.project.rpg.models.items.armor;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.AbstractItem;

public abstract class AbstractArmor extends AbstractItem {

    private Resistance mResistance;

    public AbstractArmor() {
    }

    protected AbstractArmor(String name) {
        super(name);
    }

    public Resistance getResistance() {
		return mResistance;
	}

	protected void setResistance(Resistance resistance) {
		mResistance = resistance;
	}

    @Override
    protected void setItemType() {
        mItemType = ItemType.ARMOR;
    }

    @Override
    public void use(AbstractCharacter character) {

    }

    @Override
    public StringMessageDialogFragment getUseItemDialogFragment(Context context) {
        return null;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeSerializable(mResistance);

    }

    protected AbstractArmor(Parcel in) {
        super(in);
        mResistance = (Resistance) in.readSerializable();
    }
}
