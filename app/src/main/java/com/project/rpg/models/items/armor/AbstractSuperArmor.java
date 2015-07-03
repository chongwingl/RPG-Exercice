package com.project.rpg.models.items.armor;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 7/6/15.
 */
public class AbstractSuperArmor extends AbstractArmor{

    private static final long serialVersionUID = -5281858818206714715L;

    public AbstractSuperArmor(String name) {
        super(name);
    }


    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL6;
    }
}
