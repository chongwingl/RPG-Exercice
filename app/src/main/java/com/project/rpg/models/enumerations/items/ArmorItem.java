package com.project.rpg.models.enumerations.items;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.items.armor.body.BasicArmor;
import com.project.rpg.models.items.armor.body.BasicTunic;
import com.project.rpg.models.items.armor.foot.BasicBoot;
import com.project.rpg.models.items.armor.foot.BasicShoe;
import com.project.rpg.models.items.armor.head.BasicCap;
import com.project.rpg.models.items.armor.head.BasicHat;
import com.project.rpg.models.items.armor.head.BasicHelmet;
import com.project.rpg.models.items.armor.legs.BasicLegArmor;
import com.project.rpg.models.items.armor.legs.BasicPants;
import com.project.rpg.models.items.weapons.protection.BasicShield;

/**
 * Created by laetitia on 4/27/15.
 */
public enum ArmorItem {

    // body
    ARMOR(R.string.armor_armor, BasicArmor.class),
    TUNIC(R.string.armor_tunic, BasicTunic.class),
    // head
    CAP(R.string.armor_cap, BasicCap.class),
    HAT(R.string.armor_hat, BasicHat.class),
    HELMET(R.string.armor_helmet, BasicHelmet.class),
    // leg
    LEG_ARMOR(R.string.armor_leg_armor, BasicLegArmor.class),
    PANTS(R.string.armor_pants, BasicPants.class),
    // foot
    BOOT(R.string.armor_boot, BasicBoot.class),
    SHOE(R.string.armor_shoe, BasicShoe.class),
    // accessories
    SHIELD(R.string.armor_shield, BasicShield.class);

    private int mNameRefId;
    private Class mClazz;

    ArmorItem(int nameRefId, Class clazz) {
        mNameRefId = nameRefId;
        mClazz = clazz;
    }

    public int getNameRefId() {
        return mNameRefId;
    }

    public Class getClazz() {
        return mClazz;
    }

    public static ArmorItem getItemByName(Context context, String name) {
        for (ArmorItem armorItem : values()) {
            if (name.equals(context.getString(armorItem.getNameRefId()))) {
                return armorItem;
            }
        }
        return null;
    }
}
