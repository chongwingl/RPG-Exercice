package com.project.rpg.models.characters.supports;

import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterType;

public abstract class AbstractSupportCharacter extends AbstractCharacter {

    private static final long serialVersionUID = -1440551498373558893L;

	private final static int BAG_SIZE_MAX = 50;

    public AbstractSupportCharacter(CharacterType characterType, String name) {
		super(characterType, name, BAG_SIZE_MAX);
	}

    @Override
    public int getLife() {
        return 0;
    }
}
