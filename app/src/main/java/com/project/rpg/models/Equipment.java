package com.project.rpg.models;

import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;

import java.io.Serializable;

public class Equipment implements Serializable {

    private static final long serialVersionUID = -2708294008490069216L;
    private AbstractWeapon rightWeapon;
	private AbstractWeapon leftWeapon;
	private AbstractArmor headArmor;
	private AbstractArmor bodyArmor;
	private AbstractArmor legArmor;
	private AbstractArmor footArmor;
	private int weaponNumber = 0;
	private int armorNumber = 0;

    public AbstractWeapon getRightWeapon() {
		return rightWeapon;
	}
	
	public void setRightWeapon(AbstractWeapon rightWeapon) {
		this.rightWeapon = rightWeapon;
		weaponNumber += 1;
	}
	
	public void removeRightWeapon(){
		if(rightWeapon != null){
			rightWeapon = null;
			weaponNumber -= 1;
		}
	}
	
	public AbstractWeapon getLeftWeapon() {
		return leftWeapon;
	}
	
	public void setLeftWeapon(AbstractWeapon leftWeapon) {
		this.leftWeapon = leftWeapon;
		weaponNumber += 1;
	}
	
	public void removeLeftWeapon(){
		if(leftWeapon != null){
			leftWeapon = null;
			weaponNumber -= 1;
		}
	}
	
	public AbstractArmor getHeadArmor() {
		return headArmor;
	}
	
	public void setHeadArmor(AbstractArmor headArmor) {
		this.headArmor = headArmor;
		armorNumber += 1;
	}
	
	public void removeHeadArmor(){
		if(headArmor != null){
			headArmor = null;
			armorNumber -= 1;
		}
	}
	
	public AbstractArmor getBodyArmor() {
		return bodyArmor;
	}
	
	public void setBodyArmor(AbstractArmor bodyArmor) {
		this.bodyArmor = bodyArmor;
		armorNumber += 1;
	}
	
	public void removeBodyArmor(){
		if(bodyArmor != null){
			bodyArmor = null;
			armorNumber -= 1;
		}
	}
	
	public AbstractArmor getLegArmor() {
		return legArmor;
	}
	
	public void setLegArmor(AbstractArmor legArmor) {
		this.legArmor = legArmor;
		armorNumber += 1;
	}
	
	public void removeLegArmor(){
		if(legArmor != null){
			legArmor = null;
			armorNumber -= 1;
		}
	}

    public AbstractArmor getFootArmor() {
        return footArmor;
    }

    public void setFootArmor(AbstractArmor footArmor) {
        this.footArmor = footArmor;
        armorNumber += 1;
    }

    public void removeFootArmor(){
        if(legArmor != null){
            legArmor = null;
            armorNumber -= 1;
        }
    }
	
	public int getArmorNumber(){
		return armorNumber;
	}
	
	public int getWeaponNumber(){
		return weaponNumber;
	}
	
	public Weight getEquipementWeight(){
		int totalWeight = 0;
		if(rightWeapon != null){
			totalWeight += rightWeapon.getWeight().getValue();
		}
		if(leftWeapon != null){
			totalWeight += leftWeapon.getWeight().getValue();
		}
		if(headArmor != null){
			totalWeight += headArmor.getWeight().getValue();
		}
		if(bodyArmor != null){
			totalWeight += bodyArmor.getWeight().getValue();
		}
		if(legArmor != null){
			totalWeight += legArmor.getWeight().getValue();
		}
		
		return Weight.getConstant(Math.round(totalWeight / (armorNumber + weaponNumber)));
	}
	
	public Resistance getEquipementResistance(){
		int totalResistance = 0;
		if(headArmor != null){
			totalResistance += headArmor.getResistance().getValue();
		}
		if(bodyArmor != null){
			totalResistance += bodyArmor.getResistance().getValue();
		}
		if(legArmor != null){
			totalResistance += legArmor.getResistance().getValue();
		}
		
		return Resistance.getConstant(Math.round(totalResistance / armorNumber));
	}
	
	public Strength getEquipementStrength(){
		int totalStrength = 0;
		if(rightWeapon != null){
			totalStrength += rightWeapon.getStrength().getValue();
		}
		if(leftWeapon != null){
			totalStrength += leftWeapon.getStrength().getValue();
		}

		return Strength.getConstant(Math.round(totalStrength / weaponNumber));
	}
	
	public Accuracy getEquipementAccuracy(){
		int totalAccuracy = 0;
		if(rightWeapon != null){
			totalAccuracy += rightWeapon.getAccuracy().getValue();
		}
		if(leftWeapon != null){
			totalAccuracy += leftWeapon.getAccuracy().getValue();
		}
		
		return Accuracy.getConstant(Math.round(totalAccuracy / weaponNumber));
	}
}
