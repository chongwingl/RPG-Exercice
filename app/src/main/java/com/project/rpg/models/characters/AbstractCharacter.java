package com.project.rpg.models.characters;

import com.project.rpg.exceptions.NoItemInBagException;
import com.project.rpg.exceptions.NotEnoughGoldException;
import com.project.rpg.models.Bag;
import com.project.rpg.models.enumerations.CharacterClass;
import com.project.rpg.models.events.UpdateGoldEvent;
import com.project.rpg.models.items.AbstractItem;

import java.io.Serializable;

import de.greenrobot.event.EventBus;

public abstract class AbstractCharacter
        implements Serializable {

    private static final long serialVersionUID = 7574347050097636816L;

    private static final int INIT_GOLD = 200;

    private CharacterClass mCharacterClass;
    private String mName;
    private int mGold;
    private Bag mBag;

    protected AbstractCharacter(CharacterClass characterClass, String name, int maxBagSize) {
        this.mCharacterClass = characterClass;
        this.mName = name;
        mBag = Bag.getInstance(maxBagSize);
        setGold(INIT_GOLD);
    }

    public CharacterClass getCharacterType() {
        return mCharacterClass;
    }

    public String getName() {
        return mName;
    }

    public int getGold() {
        return mGold;
    }

    public void setGold(int gold) {
        this.mGold = gold;
    }

    public void addGold(int gold) {
        this.mGold += gold;
        EventBus.getDefault().post(new UpdateGoldEvent(getGold()));
    }

    public void removeGold(int gold) throws NotEnoughGoldException {
        if (this.mGold < gold) {
            throw new NotEnoughGoldException();
        }
        this.mGold -= gold;
        EventBus.getDefault().post(new UpdateGoldEvent(getGold()));
    }

    public void addToBag(AbstractItem item) {
        mBag.addItem(item);
    }

    public Bag getBag() {
        return mBag;
    }

    public void removeItemFromBag(AbstractItem item) throws NoItemInBagException{
        mBag.removeItem(item);
    }

    public abstract int getSpecialStat();

    public abstract int getSpecialMaxStat();

    public abstract int getSpecialStatIconId();

}
