package com.project.rpg.models.items.weapons.hammers;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicHammer extends AbstractBasicWeapon {

    private static final long serialVersionUID = 4938497316908847755L;

	private final static int PRICE = 60;

    public BasicHammer(Context context) {
		super(context.getString(R.string.weapon_hammer));
		setAccuracy(Accuracy.NORMAL);
		setStrength(Strength.MEDIUM);
		setWeight(Weight.NORMAL);
        setPrice(PRICE);
	}

	public static final Parcelable.Creator<BasicHammer> CREATOR
			= new Parcelable.Creator<BasicHammer>() {
		public BasicHammer createFromParcel(Parcel in) {
			return new BasicHammer(in);
		}

		public BasicHammer[] newArray(int size) {
			return new BasicHammer[size];
		}
	};

	private BasicHammer(Parcel in) {
		super(in);
	}
}
