package com.project.rpg.models.enumerations;

public enum Weight {
	// Objets directement construits
	SUPERLIGHT (5),
	LIGHT(10),
	MEDIUM(15),
	NORMAL(20),
	HEAVY(25),
	SUPERHEAVY(30);

	private int weight = 0;

	// Constructeur
	Weight(int weight) {
		this.weight = weight;
	}

	public int getValue(){
		return weight;
	}
	
	public static Weight getConstant(int value){
		switch (value) {
		case 5:
			return SUPERLIGHT;
		case 10:
			return LIGHT;
		case 15:
			return MEDIUM;
		case 20:
			return NORMAL;
		case 25:
			return HEAVY;
		case 30:
			return SUPERHEAVY;
		default:
			return null;
		}
	}
}
