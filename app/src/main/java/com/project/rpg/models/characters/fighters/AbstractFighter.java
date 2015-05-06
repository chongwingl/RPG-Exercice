package com.project.rpg.models.characters.fighters;

import com.project.rpg.models.Equipment;
import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.AbstractCharacter;

public abstract class AbstractFighter extends AbstractCharacter {

	private final static int BAG_SIZE_MAX = 15;
	private Stat staticStat;
	private Stat effectiveStat;

	private Equipment equipment;

	public AbstractFighter(String name, int maxLifePoints, int strength,
			int speed, int accuracy, int resistance) {
		super(name);
		staticStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
		effectiveStat = new Stat(maxLifePoints);
		equipment = new Equipment();
	}

	public Equipment getEquipment() {
		return equipment;
	}
}
