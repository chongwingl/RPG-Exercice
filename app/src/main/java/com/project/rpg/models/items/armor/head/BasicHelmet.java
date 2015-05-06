package com.project.rpg.models.items.armor.head;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicHelmet extends AbstractArmor {

	public BasicHelmet(Context context) {
		super(context, R.string.armor_helmet);
		setResistance(Resistance.MEDIUM);
		setWeight(Weight.NORMAL);
	}

}
