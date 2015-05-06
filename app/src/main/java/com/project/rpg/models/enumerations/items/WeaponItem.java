package com.project.rpg.models.enumerations.items;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.items.weapons.axes.BasicAxe;
import com.project.rpg.models.items.weapons.daggers.BasicDagger;
import com.project.rpg.models.items.weapons.hammers.BasicHammer;
import com.project.rpg.models.items.weapons.swords.BasicSword;

/**
 * Created by laetitia on 4/27/15.
 */
public enum WeaponItem {

    // axe
    AXE(R.string.weapon_axe, BasicAxe.class),
    //dagger
    DAGGER(R.string.weapon_dagger, BasicDagger.class),
    // hammer
    HAMMER(R.string.weapon_hammer, BasicHammer.class),
    //sword
    SWORD(R.string.weapon_sword, BasicSword.class);

    private int mNameRefId;
    private Class mClazz;

    WeaponItem(int nameRefId, Class clazz) {
        mNameRefId = nameRefId;
        mClazz = clazz;
    }

    public int getNameRefId() {
        return mNameRefId;
    }

    public Class getClazz() {
        return mClazz;
    }

    public static WeaponItem getItemByName(Context context, String name) {
        for (WeaponItem weaponItem : values()) {
            if (name.equals(context.getString(weaponItem.getNameRefId()))) {
                return weaponItem;
            }
        }
        return null;
    }
}
