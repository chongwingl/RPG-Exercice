package com.project.rpg.models.characters.supports;

import com.project.rpg.models.enumerations.CharacterType;

public class Smith extends AbstractSupportCharacter {

    private static final long serialVersionUID = 1364888975680215562L;

    public Smith(String name) {
		super(CharacterType.SMITH, name);
	}
}
