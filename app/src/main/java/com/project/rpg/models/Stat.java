package com.project.rpg.models;

import com.project.rpg.models.enumerations.CharacterState;

import java.io.Serializable;

public class Stat implements Serializable {
    private static final long serialVersionUID = 3012347748078701155L;
    private LifePoint lifePoints;
	private int strength;
	private int speed;
	private int accuracy;
	private int resistance;
	private CharacterState state = CharacterState.NOR;
	
	public Stat(int maxLifePoints){
		lifePoints = new LifePoint(maxLifePoints);
	}

	public Stat(int maxLifePoints, int strength, int speed, int accuracy, int resistance) {
		lifePoints = new LifePoint(maxLifePoints);
		this.strength = strength;
		this.speed = speed;
		this.accuracy = accuracy;
		this.resistance = resistance;
	}

	public int getStrength() {
		return strength;
	}

	protected void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	protected void setSpeed(int speed) {
		this.speed = speed;
	}

	public LifePoint getLifePoints() {
		return lifePoints;
	}
	
	public int getAccuracy() {
		return accuracy;
	}

	protected void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getResistance() {
		return resistance;
	}

	protected void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public CharacterState getState() {
		return state;
	}

	public void setState(CharacterState state) {
		this.state = state;
	}
}
