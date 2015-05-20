package com.project.rpg.models.characters.fighters;

import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.models.Stat;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.utils.RandomGenerator;

public class Knight extends AbstractFighter {

    private static final long serialVersionUID = -4324249331855726182L;

	public Knight(String name) {
		super(CharacterType.KNIGHT, name, 100, 30, 20, 65, 30);
	}

    @Override
	public int attack(AbstractMonster monster) throws AttackMissedException {
        int random = RandomGenerator.getRandomInteger(0, Stat.MAX_STAT);
        int damages;
        if (random < mStat.getAccuracy()) {
            int strength = mStat.getStrength();
            if (strength > monster.getResistance()) {
                damages = strength;
            } else {
                int diff = monster.getResistance() - strength;
                int random2 = RandomGenerator.getRandomInteger(0, diff);
                damages = strength - random2;
            }
            return damages;
        } else {
            throw new AttackMissedException();
        }
	}

    @Override
    public boolean willAttackFirst(AbstractMonster monster) {
        int speedDiff = mStat.getSpeed() - monster.getSpeed();
        if (speedDiff > 0) {
            int random = RandomGenerator.getRandomInteger(0, 100);
            if (random <= speedDiff) {
                return true;
            }
        }
        return false;
    }

    // Reminder
    // fight against weak : win 1 potion
    // fight against same strength : 1pt of stat, 10 pt of life, one object
    // fight against strong : 2pt of stat, 20 pt of life, one object

}
