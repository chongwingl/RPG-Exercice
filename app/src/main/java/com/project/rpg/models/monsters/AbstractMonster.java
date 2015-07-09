package com.project.rpg.models.monsters;

import com.project.rpg.R;
import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.generators.RandomGenerator;
import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.powers.AbstractPower;

public abstract class AbstractMonster extends AbstractFighter {

    private static final long serialVersionUID = -4281126169918483572L;

    private AbstractPower mPower;
    private Stat mStat;
    private MonsterLevel mLevel;

    public AbstractMonster(String name, int maxLifePoints, int strength,
                           int speed, int accuracy, int resistance) {
        super(CharacterType.MONSTER, name, maxLifePoints, strength, speed, accuracy, resistance);
        mStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
    }

    public AbstractPower getPower() {
        return mPower;
    }

    protected void setPower(AbstractPower mPower) {
        this.mPower = mPower;
    }

    public Stat getStat() {
        return mStat;
    }

    public int getLife() {
        return mStat.getLifePoints().getLife();
    }

    public void removeLife(int points) throws NoMoreLifeException {
        mStat.getLifePoints().removeLife(points);
    }

    @Override
    public int getSpecialStat() {
        return getLife();
    }

    @Override
    public int getSpecialStatIconId() {
        return R.drawable.heart_white;
    }

    @Override
    public int getSpecialMaxStat() {
        return getStat().getLifePoints().getMaxLifePoint();
    }

    public int getStrength() {
        return mStat.getStrength();
    }

    public int getSpeed() {
        return mStat.getSpeed();
    }

    public int getAccuracy() {
        return mStat.getAccuracy();
    }

    public int getResistance() {
        return mStat.getResistance();
    }

    public MonsterLevel getLevel() {
        return mLevel;
    }

    public void setLevel(MonsterLevel level) {
        this.mLevel = level;
    }

    public int attack(AbstractFighter fighter) throws AttackMissedException {
        int random = RandomGenerator.getRandomInteger(0, Stat.MAX_STAT);
        int strength = mStat.getStrength();
        int damages = strength;
        if (random <= mStat.getAccuracy()) {
            if (strength < fighter.getStat().getResistance()) {
                int diff = fighter.getStat().getResistance() - strength;
                int random2 = RandomGenerator.getRandomInteger(0, diff);
                damages = strength - random2;
            }
            return damages;
        } else {
            throw new AttackMissedException();
        }
    }

    public boolean willAttackFirst(AbstractFighter fighter) {
        int speedDiff = mStat.getSpeed() - fighter.getStat().getSpeed();
        if (speedDiff > 0) {
            int random = RandomGenerator.getRandomInteger(0, 100);
            if (random <= speedDiff) {
                return true;
            }
        }
        return false;
    }
}
