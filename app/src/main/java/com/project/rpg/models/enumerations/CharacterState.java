package com.project.rpg.models.enumerations;

public enum CharacterState {
	// Objets directement construits
	NOR("Normal"), PAR("Paralysie"), SOM("Sommeil"), POI("Poison"), DEAD("Mort");

	private String state = "";

	// Constructeur
	CharacterState(String state) {
		this.state = state;
	}

	public String toString() {
		return state;
	}
}
