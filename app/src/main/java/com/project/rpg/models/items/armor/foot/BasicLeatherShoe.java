package com.project.rpg.models.items.armor.foot;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicLeatherShoe extends AbstractBasicArmor {

    private static final int PRICE = 20;

    public BasicLeatherShoe() {
    }

    public BasicLeatherShoe(Context context) {
        super(context.getString(R.string.armor_shoe));
        setResistance(Resistance.WEAK);
        setWeight(Weight.LIGHT);
        setPrice(PRICE);
    }

    protected BasicLeatherShoe(Parcel in) {
        super(in);
    }
}
