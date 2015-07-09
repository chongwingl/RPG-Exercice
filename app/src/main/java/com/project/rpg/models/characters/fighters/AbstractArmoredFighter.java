package com.project.rpg.models.characters.fighters;

import android.os.Parcel;

import com.project.rpg.generators.StatGenerator;
import com.project.rpg.models.Equipment;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;

/**
 * Created by laetitia on 7/8/15.
 */
public abstract class AbstractArmoredFighter extends AbstractFighter {

    protected Equipment mEquipment;

    public AbstractArmoredFighter() {
    }

    public AbstractArmoredFighter(CharacterType characterType, String name, int maxLifePoints, int strength, int speed, int accuracy, int resistance) {
        super(characterType, name, maxLifePoints, strength, speed, accuracy, resistance);
        mEquipment = new Equipment();
    }

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

    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeParcelable(mEquipment, flags);
    }

    protected AbstractArmoredFighter(Parcel in) {
        super(in);
        mEquipment = in.readParcelable(mEquipment.getClass().getClassLoader());
    }
}
