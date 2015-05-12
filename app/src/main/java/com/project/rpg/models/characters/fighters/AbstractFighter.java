package com.project.rpg.models.characters.fighters;

import com.project.rpg.models.Equipment;
import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterType;

public abstract class AbstractFighter extends AbstractCharacter {

    private static final long serialVersionUID = 7431707900608571006L;

	private final static int BAG_SIZE_MAX = 15;
    private Stat mStat;

	private Equipment equipment;

	public AbstractFighter(CharacterType characterType, String name, int maxLifePoints, int strength,
			int speed, int accuracy, int resistance) {
		super(characterType, name, BAG_SIZE_MAX);
        mStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
		equipment = new Equipment();
	}

	public Equipment getEquipment() {
		return equipment;
	}

    @Override
    public int getLife() {
        return mStat.getLifePoints().getLifePoints();
    }

    public Stat getStat() {
        return mStat;
    }


}
