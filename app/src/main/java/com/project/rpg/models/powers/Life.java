package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 5/20/15.
 */
public class Life extends AbstractPower {

    private static final long serialVersionUID = 4000312708135062484L;

    private int mLifePointsToRestore;

    public Life(int lifePoints) {
        super("Life", 1, 1, Probability.LEVEL10);
        mLifePointsToRestore = lifePoints;
    }

    @Override
    public Object getPowerEffect() {
        return mLifePointsToRestore;
    }
}
