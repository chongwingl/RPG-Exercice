package com.project.rpg.models.items.weapons.axes;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicAxe extends AbstractBasicWeapon {

    private static final long serialVersionUID = -1225839577399381945L;

	private final static int PRICE = 50;

    public BasicAxe(Context context) {
		super(context.getString(R.string.weapon_axe));
		setAccuracy(Accuracy.NORMAL);
		setAccuracyWhenBroken(Accuracy.LOW);
		setHitsBeforeSharpening(25);
		setNumberOfSharpening(3);
		setStrength(Strength.MEDIUM);
		setStrengthWhenBroken(Strength.LOW);
		setWeight(Weight.NORMAL);
		setPrice(PRICE);
	}
}
