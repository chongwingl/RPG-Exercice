package com.project.rpg.models.items.armor.body;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractSuperArmor;

public class SuperMetalArmor extends AbstractSuperArmor {

	private static final int PRICE = 50;

	public SuperMetalArmor() {
	}

	public SuperMetalArmor(Context context) {
		super(context.getString(R.string.armor_super_metal_armor));
		setResistance(Resistance.NORMAL);
		setWeight(Weight.HEAVY);
        setPrice(PRICE);
	}

	protected SuperMetalArmor(Parcel in) {
		super(in);
	}
}
