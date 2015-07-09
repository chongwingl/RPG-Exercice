package com.project.rpg.models.enumerations;

public enum Weight {
	// Objets directement construits
    NONE(0),
	SUPERLIGHT (10),
	LIGHT(15),
	MEDIUM(20),
	NORMAL(25),
	HEAVY(30),
	SUPERHEAVY(35);

	private int weight = 0;

	// Constructeur
	Weight(int weight) {
		this.weight = weight;
	}

	public int getValue(){
		return weight;
	}
	
	public static Weight getConstant(int value){
        if (value == 0) {
            return NONE;
        } else if (value <= SUPERLIGHT.getValue()) {
			return SUPERLIGHT;
        } else if (value <= LIGHT.getValue()) {
			return LIGHT;
        } else if (value <= MEDIUM.getValue()) {
			return MEDIUM;
        } else if (value <= NORMAL.getValue()) {
			return NORMAL;
        } else if (value <= HEAVY.getValue()) {
			return HEAVY;
        } else {
			return SUPERHEAVY;
        }
	}
}
