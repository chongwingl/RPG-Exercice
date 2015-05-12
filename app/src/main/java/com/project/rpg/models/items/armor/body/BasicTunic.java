package com.project.rpg.models.items.armor.body;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicTunic extends AbstractArmor {

    private static final long serialVersionUID = 4334998169220008591L;

    public BasicTunic(Context context) {
		super(context.getString(R.string.armor_tunic));
		setResistance(Resistance.WEAK);
		setWeight(Weight.SUPERLIGHT);
	}

}
