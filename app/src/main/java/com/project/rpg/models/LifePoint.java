package com.project.rpg.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.models.enumerations.CharacterState;

import java.io.Serializable;

public class LifePoint implements Parcelable {

    private int mLife;
    private int MAX_LIFE;

    public LifePoint(int maxLife) {
        MAX_LIFE = maxLife;
        mLife = maxLife;
    }

    public void setMaxLifePoint(int maxLife) {
        MAX_LIFE = maxLife;
    }

    public void setLifePoint(int life) {
        mLife = life;
    }

    public int getMaxLifePoint() {
        return MAX_LIFE;
    }

    public int getLife() {
        return mLife;
    }

    public void addLife(int life) {
        this.mLife += life;
        if (this.mLife > MAX_LIFE) {
            this.mLife = MAX_LIFE;
        }
    }

    public void removeLife(int life) throws NoMoreLifeException {
        this.mLife -= life;
        if (this.mLife <= 0) {
            this.mLife = 0;
            throw new NoMoreLifeException();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mLife);
        out.writeInt(MAX_LIFE);
    }

    public static final Parcelable.Creator<LifePoint> CREATOR
            = new Parcelable.Creator<LifePoint>() {
        public LifePoint createFromParcel(Parcel in) {
            return new LifePoint(in);
        }

        public LifePoint[] newArray(int size) {
            return new LifePoint[size];
        }
    };

    private LifePoint(Parcel in) {
        mLife = in.readInt();
        MAX_LIFE = in.readInt();
    }
}
