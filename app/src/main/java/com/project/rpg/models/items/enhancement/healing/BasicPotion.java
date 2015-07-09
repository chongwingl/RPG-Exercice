package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicPotion extends AbstractPotion {

    private static final int LIFE_RESTORED = 20;
    private static final int PRICE = 40;

    public BasicPotion() {
    }

    public BasicPotion(Context context) {
        super(context.getString(R.string.healing_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL8;
    }

    public static final Parcelable.Creator<BasicPotion> CREATOR
            = new Parcelable.Creator<BasicPotion>() {
        public BasicPotion createFromParcel(Parcel in) {
            return new BasicPotion(in);
        }

        public BasicPotion[] newArray(int size) {
            return new BasicPotion[size];
        }
    };

    private BasicPotion(Parcel in) {
        super(in);
    }
}
