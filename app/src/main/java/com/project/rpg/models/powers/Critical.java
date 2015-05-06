package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

public class Critical extends AbstractPower {
	
	private static int percentPointsTaken = 30;

	public Critical() {
		super("Critique", 0, 1, Probability.LEVEL3);
	}
	
	public int takenPoints(int lifePoints){
		return lifePoints * (percentPointsTaken/100);
	}
}
