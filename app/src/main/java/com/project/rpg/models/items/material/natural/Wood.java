package com.project.rpg.models.items.material.natural;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Wood extends AbstractMaterial {

    public Wood() {
    }

    public Wood(Context context) {
		super(context.getString(R.string.material_wood), Probability.LEVEL9);
        setPrice(10);
	}

    public static final Parcelable.Creator<Wood> CREATOR
            = new Parcelable.Creator<Wood>() {
        public Wood createFromParcel(Parcel in) {
            return new Wood(in);
        }

        public Wood[] newArray(int size) {
            return new Wood[size];
        }
    };

    private Wood(Parcel in) {
        super(in);
    }
}
