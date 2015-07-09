package com.project.rpg.models.items.weapons.protection;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicShield extends AbstractBasicWeapon {

    private final static int PRICE = 40;

    public BasicShield(Context context) {
		super(context.getString(R.string.armor_shield));
		setWeight(Weight.NORMAL);
        setAccuracy(Accuracy.WEAK);
        setStrength(Strength.WEAK);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
	}

    public static final Parcelable.Creator<BasicShield> CREATOR
            = new Parcelable.Creator<BasicShield>() {
        public BasicShield createFromParcel(Parcel in) {
            return new BasicShield(in);
        }

        public BasicShield[] newArray(int size) {
            return new BasicShield[size];
        }
    };

    private BasicShield(Parcel in) {
        super(in);
    }
}
