package com.project.rpg.models.items.weapons.daggers;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicDagger extends AbstractWeapon {

	public BasicDagger(Context context) {
		super(context, R.string.weapon_dagger);
		setAccuracy(Accuracy.NORMAL);
		setmAccuracyWhenBroken(Accuracy.LOW);
		setmHitsBeforeSharpening(25);
		setNumberOfSharpening(3);
		setStrength(Strength.MEDIUM);
		setStrengthWhenBroken(Strength.WEAK);
		setWeight(Weight.LIGHT);
	}

}
