package com.project.rpg.models.enumerations;

public enum Resistance {
	// Objets directement construits
    NONE(0),
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
