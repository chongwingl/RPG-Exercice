package com.project.rpg.models.enumerations;

public enum Strength {
	// Objets directement construits
    NONE(0),
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
        if (value == 0) {
            return NONE;
        } else if (value <= WEAK.getValue()) {
            return WEAK;
        } else if (value <= LOW.getValue()) {
            return LOW;
        } else if (value <= MEDIUM.getValue()) {
            return MEDIUM;
        } else if (value <= NORMAL.getValue()) {
            return NORMAL;
        } else {
            return HIGH;
        }
    }
}
