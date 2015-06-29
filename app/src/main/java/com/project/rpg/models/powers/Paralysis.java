package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

public class Paralysis extends AbstractPower {

    private static final long serialVersionUID = -8226064454213888309L;

    public Paralysis() {
		super("Paralysie", 2, 5, Probability.LEVEL3);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

}
