package com.project.rpg.models.items.armor.body;

import android.content.Context;
import android.os.Parcel;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractBasicArmor;

public class BasicTunic extends AbstractBasicArmor {

	private static final int PRICE = 30;

	public BasicTunic() {
	}

	public BasicTunic(Context context) {
		super(context.getString(R.string.armor_basic_tunic));
		setResistance(Resistance.WEAK);
		setWeight(Weight.SUPERLIGHT);
        setPrice(PRICE);
	}

	protected BasicTunic(Parcel in) {
		super(in);
	}

}
