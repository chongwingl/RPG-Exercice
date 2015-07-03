package com.project.rpg.generators;

import com.project.rpg.models.enumerations.MonsterLevel;

/**
 * Created by laetitia on 7/6/15.
 */
public final class CoinGenerator {

    public static int generateCoins(MonsterLevel level, int characterStrength, int monsterStrength) {
        final int diff = Math.abs(characterStrength - monsterStrength);
        final int highest = diff + level.getLevel();
        int lowest = diff - level.getLevel();
        if (lowest < 0) {
            lowest = 0;
        }
        return level.getLevel() + RandomGenerator.getRandomInteger(lowest, highest);
    }
}
