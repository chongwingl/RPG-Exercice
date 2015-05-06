package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicArmor extends AbstractArmor {


	public BasicArmor(Context context) {
		super(context, R.string.armor_armor);
		setResistance(Resistance.NORMAL);
		setWeight(Weight.HEAVY);
	}
}
