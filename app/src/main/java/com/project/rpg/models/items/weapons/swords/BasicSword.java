package com.project.rpg.models.items.weapons.swords;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicSword extends AbstractWeapon {

	public BasicSword(Context context) {
		super(context, R.string.weapon_sword);
		setAccuracy(Accuracy.NORMAL);
		setmAccuracyWhenBroken(Accuracy.LOW);
		setmHitsBeforeSharpening(25);
		setNumberOfSharpening(3);
		setStrength(Strength.LOW);
		setStrengthWhenBroken(Strength.WEAK);
		setWeight(Weight.NORMAL);
	}

}
