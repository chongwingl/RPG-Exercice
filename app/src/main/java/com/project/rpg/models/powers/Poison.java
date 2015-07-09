package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;

public class Poison extends AbstractPower {

    private static int percentPointsTaken = 10;
	
	public Poison() {
		super("Poison", 2, 5, Probability.LEVEL3);
	}

	public int takenPoints(int lifePoints) {
		return lifePoints * (percentPointsTaken/100);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

    public static final Parcelable.Creator<Poison> CREATOR
            = new Parcelable.Creator<Poison>() {
        public Poison createFromParcel(Parcel in) {
            return new Poison(in);
        }

        public Poison[] newArray(int size) {
            return new Poison[size];
        }
    };

    private Poison(Parcel in) {
        super(in);
    }
}
