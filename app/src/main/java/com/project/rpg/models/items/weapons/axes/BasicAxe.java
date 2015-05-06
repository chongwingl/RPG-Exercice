package com.project.rpg.models.items.weapons.axes;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicAxe extends AbstractWeapon {

	public BasicAxe(Context context) {
		super(context, R.string.weapon_axe);
		setAccuracy(Accuracy.NORMAL);
		setmAccuracyWhenBroken(Accuracy.LOW);
		setmHitsBeforeSharpening(25);
		setNumberOfSharpening(3);
		setStrength(Strength.MEDIUM);
		setStrengthWhenBroken(Strength.LOW);
		setWeight(Weight.NORMAL);
		
	}
}
