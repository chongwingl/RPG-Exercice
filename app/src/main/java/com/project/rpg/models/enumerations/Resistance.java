package com.project.rpg.models.enumerations;

public enum Resistance {
	// Objets directement construits
	WEAK(5),
	LOW (15),
	MEDIUM(25),
	NORMAL(35),
	HIGH(45);

	private int resistance = 0;

	// Constructeur
	Resistance(int resistance) {
		this.resistance = resistance;
	}

	public int getValue(){
		return resistance;
	}
	
	public static Resistance getConstant(int value){
		switch (value) {
		case 5:
			return WEAK;
		case 15:
			return LOW;
		case 25:
			return MEDIUM;
		case 35:
			return NORMAL;
		case 45:
			return HIGH;
		default:
			return null;
		}
	}
}
