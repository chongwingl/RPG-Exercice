package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

public class Poison extends AbstractPower {

    private static final long serialVersionUID = -7539033269352909843L;
    private static int percentPointsTaken = 10;
	
	public Poison() {
		super("Poison", 2, 5, Probability.LEVEL3);
	}

	public int takenPoints(int lifePoints) {
		return lifePoints * (percentPointsTaken/100);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }

}
