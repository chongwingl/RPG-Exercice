package com.project.rpg.models.enumerations;

public enum Accuracy {
	// Objets directement construits
    NONE(0),
	WEAK(40),
	LOW (50),
	MEDIUM(60),
	NORMAL(70),
	HIGH(80);
	

	private int accuracy = 0;

	// Constructeur
	Accuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getValue(){
		return accuracy;
	}

    public static Accuracy getConstant(int value){
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
