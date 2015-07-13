package com.project.rpg.models.characters.fighters;

import android.util.Pair;

import com.project.rpg.R;
import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.generators.StatGenerator;
import com.project.rpg.models.Equipment;
import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterState;
import com.project.rpg.models.enumerations.CharacterClass;
import com.project.rpg.models.enumerations.StatType;
import com.project.rpg.models.events.UpdateSpecialStatEvent;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.utils.ItemUtils;

import de.greenrobot.event.EventBus;

public abstract class AbstractFighter extends AbstractCharacter {

    private static final long serialVersionUID = 7431707900608571006L;
    private static final int HEALING_PROB = 50;
    private static final int ARMOR_PROB = 25;
    private static final int WEAPON_PROB = 25;
    private static final int MATERIAL_PROB = 0;
    private final static int BAG_SIZE_MAX = 15;
    protected Stat mStat;
    protected Stat mBasicStat;
    public static Pair[] mItemProbability = ItemUtils.getItemProbablityArray(HEALING_PROB, ARMOR_PROB, WEAPON_PROB, MATERIAL_PROB);


    private Equipment mEquipment;

    public AbstractFighter(CharacterClass characterClass, String name, int maxLifePoints, int strength,
                           int speed, int accuracy, int resistance) {
        super(characterClass, name, BAG_SIZE_MAX);
        mStat = new Stat(maxLifePoints);
        mBasicStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
        mEquipment = new Equipment();

    }

    public int getLife() {
        return mStat.getLifePoints().getLifePoints();
    }

    public void removeLife(int points) throws NoMoreLifeException {
        try {
            mStat.getLifePoints().removeLifePoints(points);
        } catch (NoMoreLifeException e) {
            mStat.setState(CharacterState.DEAD);
            throw e;
        }
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getSpecialStat(), getSpecialMaxStat()));
    }

    public void addLife(int points) {
        mStat.getLifePoints().addLifePoints(points);
        if (mStat.getState() == CharacterState.DEAD) {
            mStat.setState(CharacterState.NOR);
        }
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getSpecialStat(), getSpecialMaxStat()));
    }

    public Stat getStat() {
        return mStat;
    }

    public void addStat(int add) {}

    @Override
    public int getSpecialStat() {
        return getLife();
    }

    @Override
    public int getSpecialMaxStat() {
        return getStat().getLifePoints().getMaxLifePoint();
    }

    @Override
    public int getSpecialStatIconId() {
        return R.drawable.heart_white;
    }

    public abstract int attack(AbstractMonster monster) throws AttackMissedException;

    public abstract boolean willAttackFirst(AbstractMonster monster);

    public AbstractWeapon getRightWeapon() {
        return mEquipment.getRightWeapon();
    }

    public void setRightWeapon(AbstractWeapon rightWeapon) {
        mEquipment.setRightWeapon(rightWeapon);
        updateStat();
    }

    public void removeRightWeapon() {
        mEquipment.removeRightWeapon();
        updateStat();
    }

    public AbstractWeapon getLeftWeapon() {
        return mEquipment.getLeftWeapon();
    }

    public void setLeftWeapon(AbstractWeapon leftWeapon) {
        mEquipment.setLeftWeapon(leftWeapon);
        updateStat();
    }

    public void removeLeftWeapon() {
        mEquipment.removeLeftWeapon();
        updateStat();
    }

    public AbstractArmor getHeadArmor() {
        return mEquipment.getHeadArmor();
    }

    public void setHeadArmor(AbstractArmor headArmor) {
        mEquipment.setHeadArmor(headArmor);
        updateStat();
    }

    public void removeHeadArmor() {
        mEquipment.removeHeadArmor();
        updateStat();
    }

    public AbstractArmor getBodyArmor() {
        return mEquipment.getBodyArmor();
    }

    public void setBodyArmor(AbstractArmor bodyArmor) {
        mEquipment.setBodyArmor(bodyArmor);
        updateStat();
    }

    public void removeBodyArmor() {
        mEquipment.removeBodyArmor();
        updateStat();
    }

    public AbstractArmor getLegArmor() {
        return mEquipment.getLegArmor();
    }

    public void setLegArmor(AbstractArmor legArmor) {
        mEquipment.setLegArmor(legArmor);
        updateStat();
    }

    public void removeLegArmor() {
        mEquipment.removeLegArmor();
        updateStat();
    }

    public AbstractArmor getFootArmor() {
        return mEquipment.getFootArmor();
    }

    public void setFootArmor(AbstractArmor footArmor) {
        mEquipment.setFootArmor(footArmor);
        updateStat();
    }

    public void removeFootArmor() {
        mEquipment.removeFootArmor();
        updateStat();
    }

    private void updateStat() {
        mStat.setAccuracy(StatGenerator.generateAccuracy(mEquipment.getEquipementAccuracy(), mBasicStat.getAccuracy()));
        mStat.setResistance(StatGenerator.generateResistance(mEquipment.getEquipementResistance(), mBasicStat.getResistance()));
        mStat.setSpeed(StatGenerator.generateSpeed(mEquipment.getEquipementWeight(), mBasicStat.getSpeed()));
        mStat.setStrength(StatGenerator.generateStrength(mEquipment.getEquipementStrength(), mBasicStat.getStrength()));
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
                mStat.addResisteance(add);
                break;
            case ACCURACY:
                mStat.addAccuracy(add);
                break;
        }
    }


}
