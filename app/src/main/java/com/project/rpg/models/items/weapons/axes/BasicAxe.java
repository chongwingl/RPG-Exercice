package com.project.rpg.models.items.weapons.axes;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicAxe extends AbstractBasicWeapon {

	private final static int PRICE = 50;

    public BasicAxe(Context context) {
		super(context.getString(R.string.weapon_axe));
		setAccuracy(Accuracy.NORMAL);
		setStrength(Strength.MEDIUM);
		setWeight(Weight.NORMAL);
		setPrice(PRICE);
	}

	public static final Parcelable.Creator<BasicAxe> CREATOR
			= new Parcelable.Creator<BasicAxe>() {
		public BasicAxe createFromParcel(Parcel in) {
			return new BasicAxe(in);
		}

		public BasicAxe[] newArray(int size) {
			return new BasicAxe[size];
		}
	};

	private BasicAxe(Parcel in) {
		super(in);
	}
}
