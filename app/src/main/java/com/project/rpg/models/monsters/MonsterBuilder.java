package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.models.Stat;
import com.project.rpg.utils.MonsterUtils;
import com.project.rpg.utils.RandomGenerator;

import java.util.List;

/**
 * Created by laetitia on 5/14/15.
 */
public final class MonsterBuilder {

    private final static int WEAK_MIN_LIFE_PERCENTAGE = 0;
    private final static int WEAK_MAX_LIFE_PERCENTAGE = 10;
    private final static int WEAK_ACCURACY_PERCENTAGE = 10;
    private final static int WEAK_SPEED_PERCENTAGE = 10;
    private final static int WEAK_RESISTANCE_PERCENTAGE = 10;

    private final static int NORMAL_STRENGTH_PERCENTAGE = 20;
    private final static int NORMAL_MIN_LIFE_PERCENTAGE = 10;
    private final static int NORMAL_MAX_LIFE_PERCENTAGE = 20;
    private final static int NORMAL_ACCURACY_PERCENTAGE = 10;
    private final static int NORMAL_SPEED_PERCENTAGE = 10;
    private final static int NORMAL_RESISTANCE_PERCENTAGE = 10;

    private final static int STRONG_MIN_LIFE_PERCENTAGE = 30;
    private final static int STRONG_MAX_LIFE_PERCENTAGE = 50;
    private final static int STRONG_RESISTANCE_PERCENTAGE = 30;
    private final static int STRONG_ACCURACY_PERCENTAGE = 30;
    private final static int STRONG_SPEED_PERCENTAGE = 30;

    private Stat mCharacterStat;

    public MonsterBuilder(Stat characterStat) {
        mCharacterStat = characterStat;
    }

    public AbstractMonster buildWeakMonster(Context context) {
        AbstractMonster monster = getMonster(context);
        Stat stat = monster.getStat();

        stat.getLifePoints().setMaxLifePoint(
                removePercentage(
                        mCharacterStat.getLifePoints().getMaxLifePoint(),
                        RandomGenerator.getRandomInteger(WEAK_MIN_LIFE_PERCENTAGE, WEAK_MAX_LIFE_PERCENTAGE)
                )
        );
        stat.getLifePoints().setLifePoint(stat.getLifePoints().getMaxLifePoint());
        stat.setAccuracy(removePercentage(mCharacterStat.getAccuracy(), WEAK_ACCURACY_PERCENTAGE));
        stat.setSpeed(removePercentage(mCharacterStat.getSpeed(), WEAK_SPEED_PERCENTAGE));
        stat.setResistance(removePercentage(mCharacterStat.getResistance(), WEAK_RESISTANCE_PERCENTAGE));

        int weakest = mCharacterStat.getStrength() - (mCharacterStat.getStrength()/2);
        int strongest = mCharacterStat.getStrength() - (mCharacterStat.getStrength()/3);
        stat.setStrength(RandomGenerator.getRandomInteger(weakest, strongest));

        return monster;
    }

    public AbstractMonster buildNormalMonster(Context context) {
        AbstractMonster monster = getMonster(context);
        Stat stat = monster.getStat();

        stat.getLifePoints().setMaxLifePoint(
                addPercentage(
                        mCharacterStat.getLifePoints().getMaxLifePoint(),
                        RandomGenerator.getRandomInteger(NORMAL_MIN_LIFE_PERCENTAGE, NORMAL_MAX_LIFE_PERCENTAGE)
                )
        );
        stat.getLifePoints().setLifePoint(stat.getLifePoints().getMaxLifePoint());
        stat.setAccuracy(getValueInRange(mCharacterStat.getAccuracy(), NORMAL_ACCURACY_PERCENTAGE));
        stat.setSpeed(getValueInRange(mCharacterStat.getSpeed(), NORMAL_SPEED_PERCENTAGE));
        stat.setResistance(getValueInRange(mCharacterStat.getResistance(), NORMAL_RESISTANCE_PERCENTAGE));
        stat.setStrength(getValueInRange(mCharacterStat.getStrength(), NORMAL_STRENGTH_PERCENTAGE));

        return monster;
    }

    public AbstractMonster buildStrongMonster(Context context) {
        AbstractMonster monster = getMonster(context);
        Stat stat = monster.getStat();

        stat.getLifePoints().setMaxLifePoint(
                addPercentage(
                        mCharacterStat.getLifePoints().getMaxLifePoint(),
                        RandomGenerator.getRandomInteger(STRONG_MIN_LIFE_PERCENTAGE, STRONG_MAX_LIFE_PERCENTAGE)
                )
        );
        stat.getLifePoints().setLifePoint(stat.getLifePoints().getMaxLifePoint());
        stat.setAccuracy(addPercentage(mCharacterStat.getAccuracy(), STRONG_ACCURACY_PERCENTAGE));
        stat.setSpeed(addPercentage(mCharacterStat.getSpeed(), STRONG_SPEED_PERCENTAGE));
        stat.setResistance(addPercentage(mCharacterStat.getResistance(), STRONG_RESISTANCE_PERCENTAGE));

        int strongest = mCharacterStat.getStrength() + (mCharacterStat.getStrength()/2);
        int weakest = mCharacterStat.getStrength() + (mCharacterStat.getStrength()/3);
        stat.setStrength(RandomGenerator.getRandomInteger(weakest, strongest));

        return monster;
    }

    private AbstractMonster getMonster(Context context){
        List<Class<?>> availableMonsters = MonsterUtils.getMonsters();
        int selectedMonster = RandomGenerator.getRandomInteger(0, availableMonsters.size());
        return MonsterUtils.getMonsterFromClass(context, availableMonsters.get(selectedMonster));
    }

    private int addPercentage(int originNumber, int percentage) {
        return originNumber + ((originNumber * percentage) / 100);
    }

    private int removePercentage(int originNumber, int percentage) {
        return originNumber - ((originNumber * percentage) / 100);
    }

    private int getValueInRange(int value, int percentage) {
        int lowest = removePercentage(value, percentage);
        int highest = addPercentage(value, percentage);
        return RandomGenerator.getRandomInteger(lowest, highest);
    }

    // Reminder
    // weak monster : strength - strength/2 > monster strength > strength - strength/3
    // weak monster : monster life = life - 10  % max
    // weak monster : monster accuracy = accuracy - 10 %
    // weak monster : monster speed = speed - 10 %
    // weak monster : monster resistance = resistance - 10 %
    // normal monster : strength - 20 % > monster strength > strength + 20 %
    // normal monster : monster life = life + 20 % max + 10 % min
    // normal monster : monster accuracy = accuracy +- 10 %
    // normal monster : monster speed = speed +- 10 %
    // normal monster : monster resistance = resistance +- 10 %
    // strong monster : strength + strength / 3 > monster strength > strength + strength / 2
    // strong monster : monster life = life + 50 % max + 30 % min
    // strong monster : monster accuracy = accuracy + 30 %
    // strong monster : monster speed = speed + 30 %
    // strong monster : monster resistance = resistance + 30 %
}
