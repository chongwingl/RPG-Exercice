package com.project.rpg.models.items.armor;

import android.content.Context;

import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.items.AbstractItem;

public abstract class AbstractArmor extends AbstractItem {

	private Resistance mResistance;

    protected AbstractArmor(Context context, int nameRefId) {
        super(context, nameRefId);
    }

    public Resistance getResistance() {
		return mResistance;
	}

	protected void setResistance(Resistance resistance) {
		mResistance = resistance;
	}

}
