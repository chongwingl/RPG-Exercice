package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Steel extends AbstractMaterial {

    public Steel() {
    }

    public Steel(Context context) {
		super(context.getString(R.string.material_steel), Probability.LEVEL5);
        setPrice(25);
	}

    public static final Parcelable.Creator<Steel> CREATOR
            = new Parcelable.Creator<Steel>() {
        public Steel createFromParcel(Parcel in) {
            return new Steel(in);
        }

        public Steel[] newArray(int size) {
            return new Steel[size];
        }
    };

    private Steel(Parcel in) {
        super(in);
    }
}
