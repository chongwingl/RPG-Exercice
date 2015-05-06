package com.project.rpg.models.items.armor.legs;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicPants extends AbstractArmor{

    public BasicPants(Context context) {
        super(context, R.string.armor_pants);
        setResistance(Resistance.WEAK);
        setWeight(Weight.LIGHT);
    }
}
