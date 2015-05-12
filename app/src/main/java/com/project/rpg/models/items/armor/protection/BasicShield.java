package com.project.rpg.models.items.armor.protection;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicShield extends AbstractArmor {

    private static final long serialVersionUID = 4958055318867751490L;

    public BasicShield(Context context) {
		super(context.getString(R.string.armor_shield));
		setResistance(Resistance.NORMAL);
		setWeight(Weight.NORMAL);
	}

}
