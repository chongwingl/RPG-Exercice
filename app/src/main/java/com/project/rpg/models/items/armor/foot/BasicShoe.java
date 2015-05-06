package com.project.rpg.models.items.armor.foot;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicShoe extends AbstractArmor {

	public BasicShoe(Context context) {
		super(context, R.string.armor_shoe);
		setResistance(Resistance.WEAK);
		setWeight(Weight.LIGHT);
	}

}
