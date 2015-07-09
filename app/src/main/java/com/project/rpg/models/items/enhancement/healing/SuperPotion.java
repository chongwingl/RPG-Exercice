package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class SuperPotion extends AbstractPotion {

    private static final int LIFE_RESTORED = 50;
    private static final int PRICE = 80;

    public SuperPotion() {
    }

    public SuperPotion(Context context) {
        super(context.getString(R.string.healing_super_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL7;
    }

    public static final Parcelable.Creator<SuperPotion> CREATOR
            = new Parcelable.Creator<SuperPotion>() {
        public SuperPotion createFromParcel(Parcel in) {
            return new SuperPotion(in);
        }

        public SuperPotion[] newArray(int size) {
            return new SuperPotion[size];
        }
    };

    private SuperPotion(Parcel in) {
        super(in);
    }
}
