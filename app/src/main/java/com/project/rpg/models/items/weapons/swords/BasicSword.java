package com.project.rpg.models.items.weapons.swords;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;
import com.project.rpg.models.items.weapons.AbstractBasicWeapon;
import com.project.rpg.models.items.weapons.AbstractWeapon;

public class BasicSword extends AbstractBasicWeapon {

    private static final long serialVersionUID = 2841968724658795947L;

    private final static int PRICE = 40;

    public BasicSword() {
    }

    public BasicSword(Context context) {
        super(context.getString(R.string.weapon_sword));
        setAccuracy(Accuracy.NORMAL);
        setStrength(Strength.LOW);
        setWeight(Weight.NORMAL);
        setPrice(PRICE);
    }

    public static final Parcelable.Creator<BasicSword> CREATOR
            = new Parcelable.Creator<BasicSword>() {
        public BasicSword createFromParcel(Parcel in) {
            return new BasicSword(in);
        }

        public BasicSword[] newArray(int size) {
            return new BasicSword[size];
        }
    };

    private BasicSword(Parcel in) {
        super(in);
    }
}
