package com.project.rpg.models.items.weapons.daggers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicDagger extends AbstractBasicWeapon {

	private final static int PRICE = 20;

    public BasicDagger(Context context) {
		super(context.getString(R.string.weapon_dagger));
		setAccuracy(Accuracy.NORMAL);
		setStrength(Strength.MEDIUM);
		setWeight(Weight.LIGHT);
        setPrice(PRICE);
	}

	public static final Parcelable.Creator<BasicDagger> CREATOR
			= new Parcelable.Creator<BasicDagger>() {
		public BasicDagger createFromParcel(Parcel in) {
			return new BasicDagger(in);
		}

		public BasicDagger[] newArray(int size) {
			return new BasicDagger[size];
		}
	};

	private BasicDagger(Parcel in) {
		super(in);
	}
}
