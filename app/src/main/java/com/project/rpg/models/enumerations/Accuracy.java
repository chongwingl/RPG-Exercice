package com.project.rpg.models.enumerations;

public enum Accuracy {
	// Objets directement construits
	WEAK(60),
	LOW (70),
	MEDIUM(80),
	NORMAL(90),
	HIGH(99);
	

	private int accuracy = 0;

	// Constructeur
	Accuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getValue(){
		return accuracy;
	}
	
	public static Accuracy getConstant(int value){
		switch (value) {
		case 60:
			return WEAK;
		case 70:
			return LOW;
		case 80:
			return MEDIUM;
		case 90:
			return NORMAL;
		case 99:
			return HIGH;
		default:
			return null;
		}
	}
}
