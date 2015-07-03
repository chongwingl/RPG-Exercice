package com.project.rpg.models.items.weapons;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractBasicWeapon extends AbstractWeapon {

    private static final long serialVersionUID = 4492089374812767198L;

    public AbstractBasicWeapon(String name) {
        super(name);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL7;
    }
}
