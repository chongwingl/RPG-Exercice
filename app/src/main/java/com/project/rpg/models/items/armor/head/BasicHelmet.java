package com.project.rpg.models.items.armor.head;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

public class BasicHelmet extends AbstractArmor {

    private static final long serialVersionUID = -8658928941690720273L;

    public BasicHelmet(Context context) {
		super(context.getString(R.string.armor_helmet));
		setResistance(Resistance.MEDIUM);
		setWeight(Weight.NORMAL);
	}

}
