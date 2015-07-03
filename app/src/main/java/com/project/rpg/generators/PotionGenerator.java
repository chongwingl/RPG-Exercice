package com.project.rpg.generators;

import android.content.Context;
import android.util.Pair;

import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.enhancement.healing.AbstractPotion;
import com.project.rpg.models.items.enhancement.healing.BasicPotion;
import com.project.rpg.models.items.enhancement.healing.HyperPotion;
import com.project.rpg.models.items.enhancement.healing.MegaPotion;
import com.project.rpg.models.items.enhancement.healing.SuperPotion;
import com.project.rpg.models.items.enhancement.healing.UltimatePotion;
import com.project.rpg.utils.ItemUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by laetitia on 7/6/15.
 */
public final class PotionGenerator {

    public static AbstractPotion generatePotion(Context context, MonsterLevel level) {
        // Recuperation de tous les items
        final List<Class<?>> healingItem = ItemUtils.getHealingItems();
        final List<AbstractPotion> potions = new ArrayList<>();
        final List<Probability> probabilities = new ArrayList<>();
        AbstractPotion potion;
        for (Class<?> aPotionItem : healingItem) {
            potion = (AbstractPotion) ItemUtils.getItemFromClass(context, aPotionItem);
            potions.add(potion);
            if (!probabilities.contains(potion.getProbabilityToFind())) {
                probabilities.add(potion.getProbabilityToFind());
            }
        }
        Collections.sort(probabilities);

        // convert the probabilities
        float sum = 0;
        Pair[] newItemProbability = new Pair[probabilities.size()];
        for (Probability aPropability : probabilities) {
            sum += aPropability.getValue();
        }
        float proportion = sum / 100;
        float prob;
        for (int i = 0; i < probabilities.size(); i++) {
            prob = probabilities.get(i).getValue() / proportion;
            newItemProbability[i] = new Pair<>(probabilities.get(i), Math.round(prob));
        }

        int rand = RandomGenerator.getRandomInteger(0, 100);
        // add 10 to get a better object
        if (level == MonsterLevel.STRONG) {
            rand +=10;
        }

        // choose an object with this probability
        int weightSum = 0;
        for (int i=0; i<newItemProbability.length; i++) {
            weightSum += (int)newItemProbability[i].second;
            if (rand < weightSum) {
                for (int j=potions.size()-1; j>=0; j--) {
                    if (potions.get(j).getProbabilityToFind() != newItemProbability[i].first) {
                        potions.remove(j);
                    }
                }
                int rand2 = RandomGenerator.getRandomInteger(0, potions.size());
                return potions.get(rand2);
            }
        }

        return new BasicPotion(context);
    }
}
