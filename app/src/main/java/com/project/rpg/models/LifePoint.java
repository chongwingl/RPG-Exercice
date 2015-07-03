package com.project.rpg.models;

import com.project.rpg.exceptions.NoMoreLifeException;

import java.io.Serializable;

public class LifePoint implements Serializable {

    private static final long serialVersionUID = 4129751603983840843L;
    private int lifePoints;
	private int MAX_LIFE_POINTS;

	public LifePoint(int maxLifePoints) {
		MAX_LIFE_POINTS = maxLifePoints;
		lifePoints = maxLifePoints;
	}

    public void setMaxLifePoint(int maxLifePoint) {
        MAX_LIFE_POINTS = maxLifePoint;
    }

    public void setLifePoint(int lifePoint) {
        lifePoints = lifePoint;
    }

    public int getMaxLifePoint() {
        return MAX_LIFE_POINTS;
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

	public void removeLifePoints(int lifePoints) throws NoMoreLifeException {
		this.lifePoints -= lifePoints;
		if (this.lifePoints <= 0) {
			this.lifePoints = 0;
			throw new NoMoreLifeException();
		}
	}
}
