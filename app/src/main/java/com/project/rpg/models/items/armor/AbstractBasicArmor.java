package com.project.rpg.models.items.armor;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractBasicArmor extends AbstractArmor {

    private static final long serialVersionUID = 7994016131353852268L;

    public AbstractBasicArmor(String name) {
        super(name);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL7;
    }
}
