package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 5/20/15.
 */
public class Life extends AbstractPower {

    private int mLifePointsToRestore;

    public Life() {
    }

    public Life(int lifePoints) {
        super("Life", 1, 1, Probability.LEVEL10);
        mLifePointsToRestore = lifePoints;
    }

    @Override
    public Object getPowerEffect() {
        return mLifePointsToRestore;
    }

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeInt(mLifePointsToRestore);
    }

    public static final Parcelable.Creator<Life> CREATOR
            = new Parcelable.Creator<Life>() {
        public Life createFromParcel(Parcel in) {
            return new Life(in);
        }

        public Life[] newArray(int size) {
            return new Life[size];
        }
    };

    private Life(Parcel in) {
        super(in);
        mLifePointsToRestore = in.readInt();
    }
}
