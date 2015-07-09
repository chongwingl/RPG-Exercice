package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Iron extends AbstractMaterial {

    public Iron() {
    }

    public Iron(Context context) {
		super(context.getString(R.string.material_iron), Probability.LEVEL7);
        setPrice(20);
	}

    public static final Parcelable.Creator<Iron> CREATOR
            = new Parcelable.Creator<Iron>() {
        public Iron createFromParcel(Parcel in) {
            return new Iron(in);
        }

        public Iron[] newArray(int size) {
            return new Iron[size];
        }
    };

    private Iron(Parcel in) {
        super(in);
    }
}
