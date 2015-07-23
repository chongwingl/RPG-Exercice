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
    private Power mAffectedByPower;
    private Life mLife;
    private CharacterStat mStat;
    private Bag mBag;
    private Equipment mEquipment;

    public Character(Context context) {
        super(context);
        mCharacterClass = context.getString(R.string.character_class);
        mBag = new Bag();
        mEquipment = new Equipment();
        mLife = new Life();
        mGold = new Gold();
    }


    public Character(Context context, String name) {
        super(context);
        mName = name;
        mCharacterClass = context.getString(R.string.character_class);
        mBag = new Bag();
        mEquipment = new Equipment();
        mLife = new Life();
        mGold = new Gold();
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getGold() {
        return mGold.getGold();
    }

    public void addGold(int gold) {
        mGold.addGold(gold);
    }

    public void removeGold(int gold) throws NotEnoughGoldException {
        mGold.removeGold(gold);
    }

    public int getMaxLife() {
        return mLife.getMaxLife();
    }

    public void setMaxLife(int maxLife) {
        mLife.setMaxLife(maxLife);
    }

    public void initMaxLife(int maxLife) {
        mLife.initMaxLife(maxLife);
    }

    public void addLife(int life) {
        mLife.addLife(life);
    }

    public void removeLife(int life) throws NoMoreLifeException {
        mLife.removeLife(life);
    }

    public String getCharacterClass() {
        return mCharacterClass;
    }

    public String getLevel() {
        return mLevel;
    }

    public void setLevel(String mLevel) {
        this.mLevel = mLevel;
    }

    public Power getAffectedByPower() {
        return mAffectedByPower;
    }

    public void setAffectedByPower(Power affectedByPower) {
        this.mAffectedByPower = affectedByPower;
    }

    public CharacterStat getStat() {
        return mStat;
    }

    public void setStat(CharacterStat mStat) {
        this.mStat = mStat;
    }

    public List<Item> getBag() {
        return mBag.getBag();
    }

    public void addItemToBag(Item item) {
        mBag.addItemToBag(item);
    }

    public void removeItemFromBag(Item item) {
        mBag.removeItemFromBag(item);
    }

    public List<Item> getEquipment() {
        return mEquipment.getEquipment();
    }

    public void addEquipment(Item equipment) {
        mEquipment.addEquipment(equipment);
    }

    public void removeEquipment(Item equipment) {
        mEquipment.removeEquipement(equipment);
    }

}
