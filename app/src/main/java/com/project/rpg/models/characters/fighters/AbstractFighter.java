package com.project.rpg.models.characters.fighters;

import com.project.rpg.R;
import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.models.Equipment;
import com.project.rpg.models.Stat;
import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.events.UpdateSpecialStatEvent;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;
import com.project.rpg.models.monsters.AbstractMonster;
import com.project.rpg.utils.StatGenerator;

import de.greenrobot.event.EventBus;

public abstract class AbstractFighter extends AbstractCharacter {

    private static final long serialVersionUID = 7431707900608571006L;

	private final static int BAG_SIZE_MAX = 15;
    protected Stat mStat;
    protected Stat mBasicStat;

	private Equipment mEquipment;

	public AbstractFighter(CharacterType characterType, String name, int maxLifePoints, int strength,
			int speed, int accuracy, int resistance) {
		super(characterType, name, BAG_SIZE_MAX);
        mStat = new Stat(maxLifePoints);
        mBasicStat = new Stat(maxLifePoints, strength, speed, accuracy, resistance);
		mEquipment = new Equipment();
	}

    public int getLife() {
        return mStat.getLifePoints().getLifePoints();
    }

    public void removeLife(int points) throws NoMoreLifeException {
        mStat.getLifePoints().removeLifePoints(points);
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getLife()));
    }

    // TODO create a listener to inform every time the life and gold changes
    public void addLife(int points) {
        mStat.getLifePoints().addLifePoints(points);
        EventBus.getDefault().post(new UpdateSpecialStatEvent(getLife()));
    }

    public Stat getStat() {
        return mStat;
    }

    @Override
    public int getSpecialStat() {
        return getLife();
    }

    @Override
    public int getSpecialStatIconId() {
        return R.drawable.heart;
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

    public void removeRightWeapon(){
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

    public void removeLeftWeapon(){
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

    public void removeHeadArmor(){
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

    public void removeBodyArmor(){
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

    public void removeLegArmor(){
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

    public void removeFootArmor(){
        mEquipment.removeFootArmor();
        updateStat();
    }

    private void updateStat(){
        mStat.setAccuracy(StatGenerator.generateAccuracy(mEquipment.getEquipementAccuracy(), mBasicStat.getAccuracy()));
        mStat.setResistance(StatGenerator.generateResistance(mEquipment.getEquipementResistance(), mBasicStat.getResistance()));
        mStat.setSpeed(StatGenerator.generateSpeed(mEquipment.getEquipementWeight(), mBasicStat.getSpeed()));
        mStat.setStrength(StatGenerator.generateStrength(mEquipment.getEquipementStrength(), mBasicStat.getStrength()));
    }


}
