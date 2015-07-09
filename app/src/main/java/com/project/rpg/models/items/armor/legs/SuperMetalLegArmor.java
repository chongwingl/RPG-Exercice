package com.project.rpg.models.items.armor.legs;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractSuperArmor;

/**
 * Created by laetitia on 4/27/15.
 */
public class SuperMetalLegArmor extends AbstractSuperArmor {

    public SuperMetalLegArmor() {
    }

    public SuperMetalLegArmor(Context context) {
        super(context.getString(R.string.armor_super_metal_leg_armor));
        setResistance(Resistance.NORMAL);
        setWeight(Weight.NORMAL);
        setPrice(40);
    }

    protected SuperMetalLegArmor(Parcel in) {
        super(in);
    }
}
