package com.project.rpg.models.enumerations;

public enum Monster {
	// Objets directement construits
	ARAIGNEE("Araignée"), SERPENT("Serpent"), LOUP("Loup"), DRAGON("Dragon");

	private String name = "";

	// Constructeur
	Monster(String name) {
		this.name = name;
	}

    @Override
    public String toString() {
        return name;
    }
}
