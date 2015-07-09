package com.project.rpg.models.items.armor.head;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicHat extends AbstractBasicArmor {

    private static final int PRICE = 20;

    public BasicHat() {
    }

    public BasicHat(Context context) {
        super(context.getString(R.string.armor_basic_hat));
        setResistance(Resistance.LOW);
        setWeight(Weight.SUPERLIGHT);
        setPrice(PRICE);
    }

    protected BasicHat(Parcel in) {
        super(in);
    }

}
