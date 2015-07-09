package com.project.rpg.models.items.armor.head;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicCap extends AbstractBasicArmor {

    private static final int PRICE = 15;

    public BasicCap() {
    }

    public BasicCap(Context context) {
        super(context.getString(R.string.armor_basic_cap));
        setResistance(Resistance.WEAK);
        setWeight(Weight.SUPERLIGHT);
        setPrice(PRICE);
    }

    protected BasicCap(Parcel in) {
        super(in);
    }

}
