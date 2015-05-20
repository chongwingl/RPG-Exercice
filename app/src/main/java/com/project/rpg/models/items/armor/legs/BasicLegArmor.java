package com.project.rpg.models.items.armor.legs;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicLegArmor extends AbstractArmor {

    private static final long serialVersionUID = -3442280494304532641L;

    public BasicLegArmor(Context context) {
        super(context.getString(R.string.armor_leg_armor));
        setResistance(Resistance.NORMAL);
        setWeight(Weight.NORMAL);
        setPrice(40);
    }
}
