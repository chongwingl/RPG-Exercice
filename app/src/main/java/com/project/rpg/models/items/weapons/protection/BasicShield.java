package com.project.rpg.models.items.weapons.protection;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicShield extends AbstractWeapon {

    private static final long serialVersionUID = 4958055318867751490L;

    public BasicShield(Context context) {
		super(context.getString(R.string.armor_shield));
		setWeight(Weight.NORMAL);
        setAccuracy(Accuracy.WEAK);
        setmAccuracyWhenBroken(Accuracy.WEAK);
        setmHitsBeforeSharpening(25);
        setNumberOfSharpening(0);
        setStrength(Strength.WEAK);
        setStrengthWhenBroken(Strength.WEAK);
        setWeight(Weight.NORMAL);
        setPrice(40);
	}

}
