package com.project.rpg.models.items.armor;

import android.content.Context;

import com.project.rpg.fragments.dialogs.UseItemDialogFragment;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.items.AbstractItem;

public abstract class AbstractArmor extends AbstractItem {

    private static final long serialVersionUID = -222751367454373841L;
    private Resistance mResistance;

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
    public UseItemDialogFragment getUseItemDialogFragment(Context context) {
        return null;
    }
}
