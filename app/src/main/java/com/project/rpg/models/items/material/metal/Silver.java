package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Silver extends AbstractMaterial {

    public Silver() {
    }

    public Silver(Context context) {
        super(context.getString(R.string.material_silver), Probability.LEVEL3);
        setPrice(30);
    }

    public static final Parcelable.Creator<Silver> CREATOR
            = new Parcelable.Creator<Silver>() {
        public Silver createFromParcel(Parcel in) {
            return new Silver(in);
        }

        public Silver[] newArray(int size) {
            return new Silver[size];
        }
    };

    private Silver(Parcel in) {
        super(in);
    }
}
