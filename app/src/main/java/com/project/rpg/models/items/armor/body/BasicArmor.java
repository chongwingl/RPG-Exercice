package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicArmor extends AbstractArmor {


    private static final long serialVersionUID = 6696349734487129643L;

    public BasicArmor(Context context) {
		super(context.getString(R.string.armor_armor));
		setResistance(Resistance.NORMAL);
		setWeight(Weight.HEAVY);
        setPrice(50);
	}
}
