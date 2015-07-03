package com.project.rpg.models.items.armor.head;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicLeatherHelmet extends AbstractBasicArmor {

    private static final long serialVersionUID = -8658928941690720273L;

    private static final int PRICE = 30;

    public BasicLeatherHelmet(Context context) {
        super(context.getString(R.string.armor_basic_leather_helmet));
        setResistance(Resistance.MEDIUM);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
    }

}
