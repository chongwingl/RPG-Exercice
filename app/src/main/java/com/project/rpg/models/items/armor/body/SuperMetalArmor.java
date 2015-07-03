package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractSuperArmor;

public class SuperMetalArmor extends AbstractSuperArmor {

    private static final long serialVersionUID = 6696349734487129643L;

	private static final int PRICE = 50;

    public SuperMetalArmor(Context context) {
		super(context.getString(R.string.armor_super_metal_armor));
		setResistance(Resistance.NORMAL);
		setWeight(Weight.HEAVY);
        setPrice(PRICE);
	}
}
