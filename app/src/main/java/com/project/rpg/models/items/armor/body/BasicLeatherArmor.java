package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicLeatherArmor extends AbstractBasicArmor {

    private static final long serialVersionUID = 6696349734487129643L;

	private static final int PRICE = 50;

    public BasicLeatherArmor(Context context) {
		super(context.getString(R.string.armor_basic_leather_armor));
		setResistance(Resistance.NORMAL);
		setWeight(Weight.HEAVY);
        setPrice(PRICE);
	}
}
