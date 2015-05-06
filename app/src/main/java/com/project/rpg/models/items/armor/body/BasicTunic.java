package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicTunic extends AbstractArmor {

	public BasicTunic(Context context) {
		super(context, R.string.armor_tunic);
		setResistance(Resistance.WEAK);
		setWeight(Weight.SUPERLIGHT);
	}

}
