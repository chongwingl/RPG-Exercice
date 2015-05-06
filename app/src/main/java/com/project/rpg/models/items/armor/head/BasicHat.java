package com.project.rpg.models.items.armor.head;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicHat extends AbstractArmor{

	public BasicHat(Context context) {
		super(context, R.string.armor_hat);
		setResistance(Resistance.LOW);
		setWeight(Weight.SUPERLIGHT);
	}

}
