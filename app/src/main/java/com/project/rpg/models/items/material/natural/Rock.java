package com.project.rpg.models.items.material.natural;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Rock extends AbstractMaterial {

    public Rock() {
    }

    public Rock(Context context) {
		super(context.getString(R.string.material_rock), Probability.LEVEL9);
        setPrice(5);
	}

    public static final Parcelable.Creator<Rock> CREATOR
            = new Parcelable.Creator<Rock>() {
        public Rock createFromParcel(Parcel in) {
            return new Rock(in);
        }

        public Rock[] newArray(int size) {
            return new Rock[size];
        }
    };

    private Rock(Parcel in) {
        super(in);
    }
}
