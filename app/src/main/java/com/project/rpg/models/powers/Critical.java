package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;

public class Critical extends AbstractPower {

    private static int percentPointsTaken = 30;

	public Critical() {
		super("Critique", 0, 1, Probability.LEVEL3);
	}
	
	public int takenPoints(int lifePoints){
		return lifePoints * (percentPointsTaken/100);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

    public static final Parcelable.Creator<Critical> CREATOR
            = new Parcelable.Creator<Critical>() {
        public Critical createFromParcel(Parcel in) {
            return new Critical(in);
        }

        public Critical[] newArray(int size) {
            return new Critical[size];
        }
    };

    private Critical(Parcel in) {
        super(in);
    }
}
