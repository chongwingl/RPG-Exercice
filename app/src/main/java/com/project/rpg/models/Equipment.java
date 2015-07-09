package com.project.rpg.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.CharacterType;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.armor.AbstractArmor;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class Equipment implements Parcelable {

    private AbstractWeapon rightWeapon;
	private AbstractWeapon leftWeapon;
	private AbstractArmor headArmor;
	private AbstractArmor bodyArmor;
	private AbstractArmor legArmor;
	private AbstractArmor footArmor;
	private int mWeaponNumber = 0;
	private int mArmorNumber = 0;

	public Equipment() {
	}

	public AbstractWeapon getRightWeapon() {
		return rightWeapon;
	}
	
	public void setRightWeapon(AbstractWeapon rightWeapon) {
		this.rightWeapon = rightWeapon;
		mWeaponNumber += 1;
	}
	
	public void removeRightWeapon(){
		if(rightWeapon != null){
			rightWeapon = null;
			mWeaponNumber -= 1;
		}
	}
	
	public AbstractWeapon getLeftWeapon() {
		return leftWeapon;
	}
	
	public void setLeftWeapon(AbstractWeapon leftWeapon) {
		this.leftWeapon = leftWeapon;
		mWeaponNumber += 1;
	}
	
	public void removeLeftWeapon(){
		if(leftWeapon != null){
			leftWeapon = null;
			mWeaponNumber -= 1;
		}
	}
	
	public AbstractArmor getHeadArmor() {
		return headArmor;
	}
	
	public void setHeadArmor(AbstractArmor headArmor) {
		this.headArmor = headArmor;
		mArmorNumber += 1;
	}
	
	public void removeHeadArmor(){
		if(headArmor != null){
			headArmor = null;
			mArmorNumber -= 1;
		}
	}
	
	public AbstractArmor getBodyArmor() {
		return bodyArmor;
	}
	
	public void setBodyArmor(AbstractArmor bodyArmor) {
		this.bodyArmor = bodyArmor;
		mArmorNumber += 1;
	}
	
	public void removeBodyArmor(){
		if(bodyArmor != null){
			bodyArmor = null;
			mArmorNumber -= 1;
		}
	}
	
	public AbstractArmor getLegArmor() {
		return legArmor;
	}
	
	public void setLegArmor(AbstractArmor legArmor) {
		this.legArmor = legArmor;
		mArmorNumber += 1;
	}
	
	public void removeLegArmor(){
		if(legArmor != null){
			legArmor = null;
			mArmorNumber -= 1;
		}
	}

    public AbstractArmor getFootArmor() {
        return footArmor;
    }

    public void setFootArmor(AbstractArmor footArmor) {
        this.footArmor = footArmor;
        mArmorNumber += 1;
    }

    public void removeFootArmor(){
        if(legArmor != null){
            legArmor = null;
            mArmorNumber -= 1;
        }
    }
	
	public int getArmorNumber(){
		return mArmorNumber;
	}
	
	public int getWeaponNumber(){
		return mWeaponNumber;
	}
	
	public Weight getEquipementWeight(){
        if (mArmorNumber + mWeaponNumber > 0) {
            int totalWeight = 0;
            if (rightWeapon != null) {
                totalWeight += rightWeapon.getWeight().getValue();
            }
            if (leftWeapon != null) {
                totalWeight += leftWeapon.getWeight().getValue();
            }
            if (headArmor != null) {
                totalWeight += headArmor.getWeight().getValue();
            }
            if (bodyArmor != null) {
                totalWeight += bodyArmor.getWeight().getValue();
            }
            if (legArmor != null) {
                totalWeight += legArmor.getWeight().getValue();
            }

            return Weight.getConstant(Math.round(totalWeight / (mArmorNumber + mWeaponNumber)));
        }
        return Weight.NONE;
	}
	
	public Resistance getEquipementResistance(){
        if (mArmorNumber > 0) {
            int totalResistance = 0;
            if (headArmor != null) {
                totalResistance += headArmor.getResistance().getValue();
            }
            if (bodyArmor != null) {
                totalResistance += bodyArmor.getResistance().getValue();
            }
            if (legArmor != null) {
                totalResistance += legArmor.getResistance().getValue();
            }

            return Resistance.getConstant(Math.round(totalResistance / mArmorNumber));
        }
        return Resistance.NONE;
	}
	
	public Strength getEquipementStrength(){
        if (mWeaponNumber > 0) {
            int totalStrength = 0;
            if (rightWeapon != null) {
                totalStrength += rightWeapon.getStrength().getValue();
            }
            if (leftWeapon != null) {
                totalStrength += leftWeapon.getStrength().getValue();
            }

            return Strength.getConstant(Math.round(totalStrength / mWeaponNumber));
        }
        return Strength.NONE;
	}
	
	public Accuracy getEquipementAccuracy(){
        if (mWeaponNumber > 0) {
            int totalAccuracy = 0;
            if (rightWeapon != null) {
                totalAccuracy += rightWeapon.getAccuracy().getValue();
            }
            if (leftWeapon != null) {
                totalAccuracy += leftWeapon.getAccuracy().getValue();
            }

            return Accuracy.getConstant(Math.round(totalAccuracy / mWeaponNumber));
        }
        return Accuracy.NONE;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeParcelable(leftWeapon, flags);
		out.writeParcelable(rightWeapon, flags);
		out.writeParcelable(headArmor, flags);
		out.writeParcelable(bodyArmor, flags);
		out.writeParcelable(legArmor, flags);
		out.writeParcelable(footArmor, flags);
		out.writeInt(mWeaponNumber);
		out.writeInt(mArmorNumber);
	}

	public static final Parcelable.Creator<Equipment> CREATOR
			= new Parcelable.Creator<Equipment>() {
		public Equipment createFromParcel(Parcel in) {
			return new Equipment(in);
		}

		public Equipment[] newArray(int size) {
			return new Equipment[size];
		}
	};

	private Equipment(Parcel in) {
		leftWeapon = in.readParcelable(leftWeapon.getClass().getClassLoader());
		rightWeapon = in.readParcelable(rightWeapon.getClass().getClassLoader());
		headArmor = in.readParcelable(headArmor.getClass().getClassLoader());
		bodyArmor = in.readParcelable(bodyArmor.getClass().getClassLoader());
		legArmor = in.readParcelable(legArmor.getClass().getClassLoader());
		footArmor = in.readParcelable(footArmor.getClass().getClassLoader());
		mWeaponNumber = in.readInt();
		mWeaponNumber = in.readInt();
	}
}
