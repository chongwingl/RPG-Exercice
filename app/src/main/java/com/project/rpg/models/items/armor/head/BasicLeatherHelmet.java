package com.project.rpg.models.items.armor.head;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicLeatherHelmet extends AbstractBasicArmor {

    private static final int PRICE = 30;

    public BasicLeatherHelmet() {
    }

    public BasicLeatherHelmet(Context context) {
        super(context.getString(R.string.armor_basic_leather_helmet));
        setResistance(Resistance.MEDIUM);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
    }

    protected BasicLeatherHelmet(Parcel in) {
        super(in);
    }

}
