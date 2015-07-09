package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class UltimatePotion extends AbstractPotion {

    private static final int LIFE_RESTORED = 500;
    private static final int PRICE = 500;

    public UltimatePotion() {
    }

    public UltimatePotion(Context context) {
        super(context.getString(R.string.healing_ultimate_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL1;
    }

    public static final Parcelable.Creator<UltimatePotion> CREATOR
            = new Parcelable.Creator<UltimatePotion>() {
        public UltimatePotion createFromParcel(Parcel in) {
            return new UltimatePotion(in);
        }

        public UltimatePotion[] newArray(int size) {
            return new UltimatePotion[size];
        }
    };

    private UltimatePotion(Parcel in) {
        super(in);
    }
}
