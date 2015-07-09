package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Gold extends AbstractMaterial {

    public Gold() {
    }

    public Gold(Context context) {
		super(context.getString(R.string.material_gold), Probability.LEVEL2);
        setPrice(40);
	}

    public static final Parcelable.Creator<Gold> CREATOR
            = new Parcelable.Creator<Gold>() {
        public Gold createFromParcel(Parcel in) {
            return new Gold(in);
        }

        public Gold[] newArray(int size) {
            return new Gold[size];
        }
    };

    private Gold(Parcel in) {
        super(in);
    }
}
