package com.project.rpg.generators;

import android.content.Context;

import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.enhancement.healing.AbstractPotion;
import com.project.rpg.models.items.enhancement.healing.BasicPotion;
import com.project.rpg.models.items.enhancement.healing.HyperPotion;
import com.project.rpg.models.items.enhancement.healing.MegaPotion;
import com.project.rpg.models.items.enhancement.healing.SuperPotion;
import com.project.rpg.models.items.enhancement.healing.UltimatePotion;

public final class StatGenerator {

    public static int generateStrength(Strength weaponStrength, int characterStrength) {
        int wStrength = weaponStrength.getValue();
        return Math.round(characterStrength += ((wStrength * characterStrength) / 100));
    }

    public static int generateAccuracy(Accuracy weaponAccuracy, int characterAccuracy) {
        int wAccuracy = weaponAccuracy.getValue();
        return Math.round(characterAccuracy += ((wAccuracy * characterAccuracy) / 100));
    }

    public static int generateSpeed(Weight weaponWeight, int characterSpeed) {
        int wWeight = weaponWeight.getValue();
        return Math.round(characterSpeed -= ((wWeight * characterSpeed) / 100));
    }

    public static int generateResistance(Resistance weaponResistance, int characterResistance) {
        int wResistance = weaponResistance.getValue();
        return Math.round(characterResistance += ((wResistance * characterResistance) / 100));
    }

}
