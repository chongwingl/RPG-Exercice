package com.project.rpg.interfaces;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.models.Stat;
import com.project.rpg.models.monsters.AbstractMonster;

/**
 * Created by laetitia on 7/8/15.
 */
public interface Attack extends Parcelable {
    int attack(AbstractMonster monster, Stat stat) throws AttackMissedException;
    boolean isAttackFirst(AbstractMonster monster, Stat stat);

    @Override
    int describeContents();

    @Override
    void writeToParcel(Parcel dest, int flags);
}
