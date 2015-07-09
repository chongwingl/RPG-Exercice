package com.project.rpg.models.items.material.animal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Bone extends AbstractMaterial {

    public Bone() {
    }

    public Bone(Context context) {
        super(context.getString(R.string.material_bone), Probability.LEVEL6);
        setPrice(20);
    }

    public static final Parcelable.Creator<Bone> CREATOR
            = new Parcelable.Creator<Bone>() {
        public Bone createFromParcel(Parcel in) {
            return new Bone(in);
        }

        public Bone[] newArray(int size) {
            return new Bone[size];
        }
    };

    private Bone(Parcel in) {
        super(in);
    }
}
