package com.project.rpg.models.items.armor.foot;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicLeatherBoot extends AbstractBasicArmor {

    private static final long serialVersionUID = -3705870619808505528L;

    private static final int PRICE = 30;

    public BasicLeatherBoot(Context context) {
        super(context.getString(R.string.armor_boot));
        setResistance(Resistance.LOW);
        setWeight(Weight.MEDIUM);
        setPrice(PRICE);
    }

}
