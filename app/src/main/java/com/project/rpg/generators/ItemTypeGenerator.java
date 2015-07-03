package com.project.rpg.generators;

import android.util.Pair;

import com.project.rpg.models.enumerations.ItemType;

/**
 * Created by laetitia on 7/7/15.
 */
public final class ItemTypeGenerator {

    public static ItemType generateItemType(Pair<ItemType, Integer>[] itemProbability) {

        int rand = RandomGenerator.getRandomInteger(0, 100);
        int sumWeight = 0;
        for (Pair<ItemType, Integer> anItemProbability : itemProbability) {
            sumWeight += anItemProbability.second;
            if (rand < sumWeight) {
                return anItemProbability.first;
            }
        }
        return ItemType.HEALING;
    }
}
