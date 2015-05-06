package com.project.rpg.models.enumerations.items;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.items.healing.potion.BasicPotion;

/**
 * Created by laetitia on 4/27/15.
 */
public enum HealingItem {

    POTION(R.string.healing_potion, BasicPotion.class);

    private int mNameRefId;
    private Class mClazz;

    HealingItem(int nameRefId, Class clazz) {
        mNameRefId = nameRefId;
        mClazz = clazz;
    }

    public int getNameRefId() {
        return mNameRefId;
    }

    public Class getClazz() {
        return mClazz;
    }

    public static HealingItem getItemByName(Context context, String name) {
        for (HealingItem healingItem : values()) {
            if (name.equals(context.getString(healingItem.getNameRefId()))) {
                return healingItem;
            }
        }
        return null;
    }
}
