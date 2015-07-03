package com.project.rpg.generators;

import android.content.Context;
import android.util.Pair;

import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;
import com.project.rpg.utils.ItemUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by laetitia on 7/6/15.
 */
public final class WeaponGenerator {

    public static AbstractWeapon generateWeapon(Context context, MonsterLevel level) {

        // Recuperation de tous les items
        final List<Class<?>> weaponItem = ItemUtils.getWeaponItems();
        final List<AbstractWeapon> weapons = new ArrayList<>();
        final List<Probability> probabilities = new ArrayList<>();
        AbstractWeapon weapon;
        for (Class<?> aWeaponItem : weaponItem) {
            weapon = (AbstractWeapon) ItemUtils.getItemFromClass(context, aWeaponItem);
            weapons.add(weapon);
            if (!probabilities.contains(weapon.getProbabilityToFind())) {
                probabilities.add(weapon.getProbabilityToFind());
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
                for (int j=weapons.size()-1; j>=0; j--) {
                    if (weapons.get(j).getProbabilityToFind() != newItemProbability[i].first) {
                        weapons.remove(j);
                    }
                }
                int rand2 = RandomGenerator.getRandomInteger(0, weapons.size());
                return weapons.get(rand2);
            }
        }

        return null;
    }

}
