package com.project.rpg.models.items.weapons.daggers;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicDagger extends AbstractBasicWeapon {

    private static final long serialVersionUID = 3949502030077144782L;

	private final static int PRICE = 20;

    public BasicDagger(Context context) {
		super(context.getString(R.string.weapon_dagger));
		setAccuracy(Accuracy.NORMAL);
		setAccuracyWhenBroken(Accuracy.LOW);
		setHitsBeforeSharpening(25);
		setNumberOfSharpening(3);
		setStrength(Strength.MEDIUM);
		setStrengthWhenBroken(Strength.WEAK);
		setWeight(Weight.LIGHT);
        setPrice(PRICE);
	}

}
