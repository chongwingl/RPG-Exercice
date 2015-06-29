package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

public class Critical extends AbstractPower {

    private static final long serialVersionUID = 404758552632375706L;
    private static int percentPointsTaken = 30;

	public Critical() {
		super("Critique", 0, 1, Probability.LEVEL3);
	}
	
	public int takenPoints(int lifePoints){
		return lifePoints * (percentPointsTaken/100);
	}

    @Override
    public Object getPowerEffect() {
        return null;
    }
}
