package com.project.rpg.engine.model;

import android.content.Context;
import android.content.ContextWrapper;

import com.project.rpg.R;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.exceptions.NotEnoughGoldException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laetitia on 7/13/15.
 */
public class Character extends ContextWrapper {

    private String mName;
    private Gold mGold;
    private String mCharacterClass;
    private String mLevel;
    private String affectedByPower;
    private Life mLife;
    private CharacterStat mStat;
    private List<Item> mBag;
    private List<Item> mEquipment;


    public Character(Context context, String name) {
        super(context);
        mName = name;
        mCharacterClass = context.getString(R.string.character_class);
        mBag = new ArrayList<>();
//        mStat = new CharacterStat();
//        mStat.addAccuracy(DEFAULT_STAT);
//        mStat.addAgility(DEFAULT_STAT);
//        mStat.addDexterity(DEFAULT_STAT);
//        mStat.addResistance(DEFAULT_STAT);
//        mStat.addSpeed(DEFAULT_STAT);
//        mStat.addStrength(DEFAULT_STAT);
    }


    public String getName() {
        return mName;
    }

    public void addGold(int gold) {
        mGold.addGold(gold);
    }

    public void removeGold(int gold) throws NotEnoughGoldException {
        mGold.removeGold(gold);
    }

    public void addLife(int life) {
        mLife.addLife(life);
    }

    public void removeLife(int life) throws NoMoreLifeException{
        mLife.removeLife(life);
    }

    public String getCharacterClass() {
        return mCharacterClass;
    }


}
