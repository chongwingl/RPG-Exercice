package com.project.rpg.models.characters.supports;

import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterClass;

public abstract class AbstractSupportCharacter extends AbstractCharacter {

    private static final long serialVersionUID = -1440551498373558893L;

    private final static int BAG_SIZE_MAX = 50;

    public AbstractSupportCharacter(CharacterClass characterClass, String name) {
        super(characterClass, name, BAG_SIZE_MAX);
    }

    @Override
    public int getSpecialStat() {
        return 0;
    }

    @Override
    public int getSpecialStatIconId() {
        return 0;
    }

    @Override
    public int getSpecialMaxStat() {
        return 0;
    }
}
