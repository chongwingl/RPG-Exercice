package com.project.rpg.models.items.armor.head;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicCap extends AbstractArmor {

	public BasicCap(Context context) {
		super(context, R.string.armor_cap);
		setResistance(Resistance.WEAK);
		setWeight(Weight.SUPERLIGHT);
	}

}
