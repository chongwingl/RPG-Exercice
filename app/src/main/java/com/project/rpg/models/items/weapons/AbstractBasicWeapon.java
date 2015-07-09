package com.project.rpg.models.items.weapons;

import android.os.Parcel;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractBasicWeapon extends AbstractWeapon {

    public AbstractBasicWeapon() {
    }

    public AbstractBasicWeapon(String name) {
        super(name);
    }

    @Override
    public Probability getProbabilityToFind() {
        return Probability.LEVEL7;
    }

    protected AbstractBasicWeapon(Parcel in) {
        super(in);
    }
}
