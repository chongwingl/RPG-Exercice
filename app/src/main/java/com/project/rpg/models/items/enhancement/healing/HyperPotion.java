package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class HyperPotion extends AbstractPotion {

    private static final int LIFE_RESTORED = 100;
    private static final int PRICE = 100;

    public HyperPotion() {
    }

    public HyperPotion(Context context) {
        super(context.getString(R.string.healing_hyper_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL5;
    }

    public static final Parcelable.Creator<HyperPotion> CREATOR
            = new Parcelable.Creator<HyperPotion>() {
        public HyperPotion createFromParcel(Parcel in) {
            return new HyperPotion(in);
        }

        public HyperPotion[] newArray(int size) {
            return new HyperPotion[size];
        }
    };

    private HyperPotion(Parcel in) {
        super(in);
    }
}
