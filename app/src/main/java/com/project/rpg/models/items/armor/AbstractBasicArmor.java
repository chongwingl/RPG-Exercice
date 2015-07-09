package com.project.rpg.models.items.armor;

import android.os.Parcel;

import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.enumerations.Resistance;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractBasicArmor extends AbstractArmor {

    public AbstractBasicArmor() {
    }

    public AbstractBasicArmor(String name) {
        super(name);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL7;
    }

    protected AbstractBasicArmor(Parcel in) {
        super(in);
    }
}
