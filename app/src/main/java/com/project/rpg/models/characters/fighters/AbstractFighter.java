package com.project.rpg.models.characters.fighters;

import android.os.Parcel;
import android.util.Pair;

import com.project.rpg.R;
import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.generators.StatGenerator;
import com.project.rpg.interfaces.Attack;
import com.project.rpg.interfaces.SpecialStat;
import com.project.rpg.models.Equipment;
import com.project.rpg.models.Stat;
import com.project.rpg.models.actions.FighterAttack;
import com.project.rpg.models.actions.FighterLifeStat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterState;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.enumerations.StatType;
import com.project.rpg.models.events.UpdateSpecialStatEvent;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.utils.ItemUtils;

import de.greenrobot.event.EventBus;

public abstract class AbstractFighter extends AbstractCharacter {

    private static final int HEALING_PROB = 50;
    private static final int ARMOR_PROB = 25;
    private static final int WEAPON_PROB = 25;
    private static final int MATERIAL_PROB = 0;
    private final static int BAG_SIZE_MAX = 15;
    protected Stat mStat;
    protected Stat mBasicStat;
    public static Pair[] mItemProbability = ItemUtils.getItemProbablityArray(HEALING_PROB, ARMOR_PROB, WEAPON_PROB, MATERIAL_PROB);
    protected Attack mAttack;

    public AbstractFighter() {
    }

    public AbstractFighter(CharacterType characterType, String name, int maxLifePoints, int strength,
                           int speed, int accuracy, int resistance) {
        super(characterType, name, BAG_SIZE_MAX, new FighterLifeStat(maxLifePoints, maxLifePoints, R.drawable.heart_white));
        mStat = new Stat(maxLifePoints);
        mBasicStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
        mAttack = new FighterAttack();
    }

    public int getLife() {
        return mStat.getLifePoints().getLife();
    }

    public void removeLife(int points) throws NoMoreLifeException {
        try {
            mStat.getLifePoints().removeLife(points);
        } catch (NoMoreLifeException e) {
            mStat.setState(CharacterState.DEAD);
            throw e;
        }
        mSpecialStat.setSpecialStat(getLife());
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getSpecialStat(), getSpecialMaxStat()));
    }

    public void addLife(int points) {
        mStat.getLifePoints().addLife(points);
        if (mStat.getState() == CharacterState.DEAD) {
            mStat.setState(CharacterState.NOR);
        }
        mSpecialStat.setSpecialStat(getLife());
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getSpecialStat(), getSpecialMaxStat()));
    }

    public void addMaxLife(int points) {
        mStat.getLifePoints().setMaxLifePoint(
                mStat.getLifePoints().getMaxLifePoint() + points
        );
        mSpecialStat.setSpecialMaxStat(mStat.getLifePoints().getMaxLifePoint());
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getSpecialStat(), getSpecialMaxStat()));
    }

    public Stat getStat() {
        return mStat;
    }

    public int attack(AbstractMonster monster) throws AttackMissedException {
        return mAttack.attack(monster, mStat);
    }

    public boolean willAttackFirst(AbstractMonster monster) {
        return mAttack.isAttackFirst(monster, mStat);
    }

    public void addStat(StatType statType, int add) {
        switch (statType) {
            case STRENGTH:
                mStat.addStrength(add);
                break;
            case SPEED:
                mStat.addSpeed(add);
                break;
            case RESISTANCE:
                mStat.addResistance(add);
                break;
            case ACCURACY:
                mStat.addAccuracy(add);
                break;
        }
    }
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(mStat, flags);
        out.writeParcelable(mBasicStat, flags);
        out.writeParcelable(mAttack, flags);
    }

    protected AbstractFighter(Parcel in) {
        super(in);
        mStat = in.readParcelable(mStat.getClass().getClassLoader());
        mBasicStat = in.readParcelable(mBasicStat.getClass().getClassLoader());
        mAttack = in.readParcelable(mAttack.getClass().getClassLoader());
    }

}
