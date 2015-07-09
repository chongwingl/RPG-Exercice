package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Copper extends AbstractMaterial {

    public Copper() {
    }

    public Copper(Context context) {
		super(context.getString(R.string.material_copper), Probability.LEVEL8);
        setPrice(10);
	}

    public static final Parcelable.Creator<Copper> CREATOR
            = new Parcelable.Creator<Copper>() {
        public Copper createFromParcel(Parcel in) {
            return new Copper(in);
        }

        public Copper[] newArray(int size) {
            return new Copper[size];
        }
    };

    private Copper(Parcel in) {
        super(in);
    }
}
