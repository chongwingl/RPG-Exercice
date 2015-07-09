package com.project.rpg.models.characters.fighters;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.models.Stat;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.generators.RandomGenerator;

public class Knight extends AbstractArmoredFighter implements Parcelable {

    private static final int LIFE = 100;
    private static final int STRENGTH = 30;
    private static final int SPEED = 20;
    private static final int ACCURACY = 75;
    private static final int RESISTANCE = 30;

    public Knight() {
    }

    public Knight(String name) {
        super(CharacterType.KNIGHT, name, LIFE, STRENGTH, SPEED, ACCURACY, RESISTANCE);
    }

    @Override
    public int attack(AbstractMonster monster) throws AttackMissedException {
        int random = RandomGenerator.getRandomInteger(1, Stat.MAX_STAT);
        int strength = mStat.getStrength();
        int damages = strength;
        if (random <= mStat.getAccuracy()) {
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
    // fight against weak : win 1 potion + little money
    // fight against same strength : 1pt of stat, 10 pt of life, one object + middle money
    // fight against strong : 2pt of stat, 20 pt of life, one object + lot of money

    public static final Parcelable.Creator<Knight> CREATOR
            = new Parcelable.Creator<Knight>() {
        public Knight createFromParcel(Parcel in) {
            return new Knight(in);
        }

        public Knight[] newArray(int size) {
            return new Knight[size];
        }
    };

    private Knight(Parcel in) {
        super(in);
    }

}