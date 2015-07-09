package com.project.rpg.models.items.material.metal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Mithril extends AbstractMaterial {

    public Mithril() {
    }

    public Mithril(Context context) {
        super(context.getString(R.string.material_mithril), Probability.LEVEL0);
        setPrice(50);
    }

    public static final Parcelable.Creator<Mithril> CREATOR
            = new Parcelable.Creator<Mithril>() {
        public Mithril createFromParcel(Parcel in) {
            return new Mithril(in);
        }

        public Mithril[] newArray(int size) {
            return new Mithril[size];
        }
    };

    private Mithril(Parcel in) {
        super(in);
    }
}
