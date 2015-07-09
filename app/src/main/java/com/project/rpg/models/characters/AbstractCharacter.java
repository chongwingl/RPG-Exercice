package com.project.rpg.models.characters;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.exceptions.NoItemInBagException;
import com.project.rpg.exceptions.NotEnoughGoldException;
import com.project.rpg.interfaces.SpecialStat;
import com.project.rpg.models.Bag;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.events.UpdateGoldEvent;
import com.project.rpg.models.items.AbstractItem;

import de.greenrobot.event.EventBus;

public abstract class AbstractCharacter implements Parcelable {

    private static final int INIT_GOLD = 200;

    protected CharacterType mCharacterType;
    protected String mName;
    protected int mGold;
    protected Bag mBag;

    protected SpecialStat mSpecialStat;

    public AbstractCharacter() {
    }

    protected AbstractCharacter(CharacterType characterType, String name, int maxBagSize, SpecialStat specialStat) {
        this.mCharacterType = characterType;
        this.mName = name;
        mBag = Bag.getInstance(maxBagSize);
        setGold(INIT_GOLD);
        mSpecialStat = specialStat;
    }

    public CharacterType getCharacterType() {
        return mCharacterType;
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

    public int getSpecialStat() {
        return mSpecialStat.getSpecialStat();
    }

    public int getSpecialMaxStat() {
        return mSpecialStat.getSpecialMaxStat();
    }

    public int getSpecialStatIconId(){
        return mSpecialStat.getSpecialStatIconId();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeSerializable(mCharacterType);
        out.writeParcelable(mBag, flags);
        out.writeParcelable(mSpecialStat, flags);
        out.writeString(mName);
        out.writeInt(mGold);
    }

    protected AbstractCharacter(Parcel in) {
        mCharacterType = (CharacterType) in.readSerializable();
        mBag = in.readParcelable(mBag.getClass().getClassLoader());
        mSpecialStat = in.readParcelable(mSpecialStat.getClass().getClassLoader());
        mName = in.readString();
        mGold = in.readInt();
    }

}
