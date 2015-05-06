package com.project.rpg.models.items.armor.foot;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicBoot extends AbstractArmor {

	public BasicBoot(Context context) {
		super(context, R.string.armor_boot);
		setResistance(Resistance.LOW);
		setWeight(Weight.MEDIUM);
	}

}
