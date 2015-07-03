package com.project.rpg.models.items.weapons.protection;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicShield extends AbstractBasicWeapon {

    private static final long serialVersionUID = 4958055318867751490L;

    private final static int PRICE = 40;

    public BasicShield(Context context) {
		super(context.getString(R.string.armor_shield));
		setWeight(Weight.NORMAL);
        setAccuracy(Accuracy.WEAK);
        setAccuracyWhenBroken(Accuracy.WEAK);
        setHitsBeforeSharpening(25);
        setNumberOfSharpening(0);
        setStrength(Strength.WEAK);
        setStrengthWhenBroken(Strength.WEAK);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
	}

}
