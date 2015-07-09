package com.project.rpg.models.characters.supports;

import com.project.rpg.models.actions.FighterLifeStat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterType;

public abstract class AbstractSupportCharacter extends AbstractCharacter {

    private final static int BAG_SIZE_MAX = 50;

    public AbstractSupportCharacter(CharacterType characterType, String name) {
        super(characterType, name, BAG_SIZE_MAX, new FighterLifeStat(0, 0, 0));
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
