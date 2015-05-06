package com.project.rpg.models.enumerations;

public enum Strength {
	// Objets directement construits
	WEAK(10),
	LOW (20),
	MEDIUM(30),
	NORMAL(40),
	HIGH(50);

	private int strength = 0;

	// Constructeur
	Strength(int strength) {
		this.strength = strength;
	}

	public int getValue(){
		return strength;
	}
	
	public static Strength getConstant(int value){
		switch (value) {
		case 10:
			return WEAK;
		case 20:
			return LOW;
		case 30:
			return MEDIUM;
		case 40:
			return NORMAL;
		case 50:
			return HIGH;
		default:
			return null;
		}
	}
}
