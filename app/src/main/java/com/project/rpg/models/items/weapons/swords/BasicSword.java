package com.project.rpg.models.items.weapons.swords;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicSword extends AbstractBasicWeapon {

    private static final long serialVersionUID = 2841968724658795947L;

    private final static int PRICE = 40;

    public BasicSword(Context context) {
        super(context.getString(R.string.weapon_sword));
        setAccuracy(Accuracy.NORMAL);
        setAccuracyWhenBroken(Accuracy.LOW);
        setHitsBeforeSharpening(25);
        setNumberOfSharpening(3);
        setStrength(Strength.LOW);
        setStrengthWhenBroken(Strength.WEAK);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
    }

}
