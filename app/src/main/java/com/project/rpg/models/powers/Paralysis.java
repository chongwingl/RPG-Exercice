package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;

public class Paralysis extends AbstractPower {

    public Paralysis() {
		super("Paralysie", 2, 5, Probability.LEVEL3);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

    public static final Parcelable.Creator<Paralysis> CREATOR
            = new Parcelable.Creator<Paralysis>() {
        public Paralysis createFromParcel(Parcel in) {
            return new Paralysis(in);
        }

        public Paralysis[] newArray(int size) {
            return new Paralysis[size];
        }
    };

    private Paralysis(Parcel in) {
        super(in);
    }

}
