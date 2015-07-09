package com.project.rpg.models.powers;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.generators.RandomGenerator;

import java.io.Serializable;

public abstract class AbstractPower implements Parcelable {

    private String name;
    private int startRange;
    private int endRange;
    private Probability probabilityToHappen;

    public AbstractPower() {
    }

    public AbstractPower(String name, int startRange, int endRange, Probability probabilityToHappen) {
        this.name = name;
        this.startRange = startRange;
        this.endRange = endRange;
        this.probabilityToHappen = probabilityToHappen;
    }

    public String getName() {
        return name;
    }

    public int roundLasting() {
        return RandomGenerator.getRandomInteger(startRange, endRange);
    }

    public boolean hasEffect() {
        int randomNumber = RandomGenerator.getRandomInteger(0, 100);
        if (randomNumber <= probabilityToHappen.getValue()) {
            return true;
        }
        return false;
    }

    public abstract Object getPowerEffect();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(startRange);
        out.writeInt(endRange);
        out.writeSerializable(probabilityToHappen);
    }

    protected AbstractPower(Parcel in) {
        name = in.readString();
        startRange = in.readInt();
        endRange = in.readInt();
        probabilityToHappen = (Probability) in.readSerializable();
    }
}
