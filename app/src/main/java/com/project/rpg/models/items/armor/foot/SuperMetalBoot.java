package com.project.rpg.models.items.armor.foot;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;
import com.project.rpg.models.items.armor.AbstractSuperArmor;

public class SuperMetalBoot extends AbstractSuperArmor {

    private static final int PRICE = 30;

    public SuperMetalBoot() {
    }

    public SuperMetalBoot(Context context) {
        super(context.getString(R.string.armor_boot));
        setResistance(Resistance.LOW);
        setWeight(Weight.MEDIUM);
        setPrice(PRICE);
    }

    protected SuperMetalBoot(Parcel in) {
        super(in);
    }

}
