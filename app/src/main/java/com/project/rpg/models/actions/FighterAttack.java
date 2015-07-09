package com.project.rpg.models.actions;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.generators.RandomGenerator;
import com.project.rpg.interfaces.Attack;
import com.project.rpg.models.Stat;
import com.project.rpg.models.monsters.AbstractMonster;

/**
 * Created by laetitia on 7/8/15.
 */
public class FighterAttack implements Attack {

    public FighterAttack() {
    }

    @Override
    public int attack(AbstractMonster monster, Stat stat) throws AttackMissedException {
        int random = RandomGenerator.getRandomInteger(1, Stat.MAX_STAT);
        int strength = stat.getStrength();
        int damages = strength;
        if (random <= stat.getAccuracy()) {
            if (strength < monster.getResistance()) {
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
    public boolean isAttackFirst(AbstractMonster monster, Stat stat) {
        int speedDiff = stat.getSpeed() - monster.getSpeed();
        if (speedDiff > 0) {
            int random = RandomGenerator.getRandomInteger(0, 100);
            if (random <= speedDiff) {
                return true;
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
    }

    public static final Parcelable.Creator<FighterAttack> CREATOR
            = new Parcelable.Creator<FighterAttack>() {
        public FighterAttack createFromParcel(Parcel in) {
            return new FighterAttack(in);
        }

        public FighterAttack[] newArray(int size) {
            return new FighterAttack[size];
        }
    };

    private FighterAttack(Parcel in) {
    }
}
