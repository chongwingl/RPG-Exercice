package com.project.rpg.models.characters;

import com.project.rpg.models.Bag;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;

import java.io.Serializable;

public abstract class AbstractCharacter
        implements Serializable {

    private static final long serialVersionUID = 7574347050097636816L;

    private CharacterType mCharacterType;
    private String mName;
    private int mLevel;
    private int mGold;
    private Bag mBag;

    protected AbstractCharacter(CharacterType characterType, String name, int maxBagSize) {
        this.mCharacterType = characterType;
        this.mName = name;
        mBag = Bag.getInstance(maxBagSize);
    }

    public CharacterType getCharacterType() {
        return mCharacterType;
    }

    public String getName() {
        return mName;
    }

    public int getLevel() {
        return mLevel;
    }

    public void setLevel(int level) {
        this.mLevel = level;
    }

    public int getGold() {
        return mGold;
    }

    public void setGold(int gold) {
        this.mGold = gold;
    }

    public void addGold(int gold) {
        this.mGold += gold;
    }

    public boolean removeGold(int gold) {
        if (this.mGold - gold > 0) {
            this.mGold -= gold;
            return true;
        }
        return false;
    }

    public void addToBag(AbstractItem item) {
        mBag.addItem(item);
    }

    public Bag getBag() {
        return mBag;
    }

    public boolean removeItem(ItemType itemType, AbstractItem item) {
        return mBag.removeItem(itemType, item);
    }

    public abstract int getLife();

}
