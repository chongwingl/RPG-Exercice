package com.project.rpg.models;

import java.io.Serializable;

public class LifePoint implements Serializable {

    private static final long serialVersionUID = 4129751603983840843L;
    private int lifePoints;
	private static int MAX_LIFE_POINTS;

	public LifePoint(int maxLifePoints) {
		MAX_LIFE_POINTS = maxLifePoints;
		lifePoints = maxLifePoints;
	}

	public int getLifePoints() {
		return lifePoints;
	}

	public void addLifePoints(int lifePoints) {
		this.lifePoints += lifePoints;
		if (this.lifePoints > MAX_LIFE_POINTS) {
			this.lifePoints = MAX_LIFE_POINTS;
		}
	}

	public boolean removeLifePoints(int lifePoints) {
		this.lifePoints -= lifePoints;
		if (this.lifePoints < 0) {
			this.lifePoints = 0;
			return false;
		}
		return true;
	}
}
