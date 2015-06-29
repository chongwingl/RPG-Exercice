package com.project.rpg.models.enumerations;

public enum Probability {
	// Objets directement construits
	LEVEL0(5),
	LEVEL1(10),
	LEVEL2(20),
	LEVEL3(30),
	LEVEL4(40),
	LEVEL5(50),
	LEVEL6(60),
	LEVEL7(70),
	LEVEL8(80),
	LEVEL9(90),
    LEVEL10(100);

	private int probability = 0;

	// Constructeur
	Probability(int probability) {
		this.probability = probability;
	}

	public int getValue(){
		return probability;
	}
}
