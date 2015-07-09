package com.project.rpg.models.items.armor;

import android.os.Parcel;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractSuperArmor extends AbstractArmor{

    public AbstractSuperArmor() {
    }

    public AbstractSuperArmor(String name) {
        super(name);
    }


    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL6;
    }

    protected AbstractSuperArmor(Parcel in) {
        super(in);
    }
}
