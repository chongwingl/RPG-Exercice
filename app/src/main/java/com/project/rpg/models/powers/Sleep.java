package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;

public class Sleep extends AbstractPower {


    public Sleep() {
		super("Sommeil", 2, 5, Probability.LEVEL3);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

    public static final Parcelable.Creator<Sleep> CREATOR
            = new Parcelable.Creator<Sleep>() {
        public Sleep createFromParcel(Parcel in) {
            return new Sleep(in);
        }

        public Sleep[] newArray(int size) {
            return new Sleep[size];
        }
    };

    private Sleep(Parcel in) {
        super(in);
    }

}
