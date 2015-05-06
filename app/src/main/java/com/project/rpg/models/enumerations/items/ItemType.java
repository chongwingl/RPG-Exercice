package com.project.rpg.models.enumerations.items;

import android.content.Context;

import com.project.rpg.R;

/**
 * Created by laetitia on 4/24/15.
 */
public enum ItemType {

    ARMOR(R.string.type_armor),
    WEAPON(R.string.type_weapon),
    MATERIAL(R.string.type_material),
    HEALING(R.string.type_healing);

    private int mNameRefId;

    ItemType(int mNameRefId) {
        this.mNameRefId = mNameRefId;
    }

    public int getNameRefId() {
        return mNameRefId;
    }

    public static ItemType getItemTypeByName(Context context, String name) {
        for (ItemType itemType : values()) {
            if (name.equals(context.getString(itemType.getNameRefId()))) {
                return itemType;
            }
        }
        return null;
    }

    public static ItemType getItemTypeByRefId(int refId) {
        for (ItemType itemType : values()) {
            if (refId == itemType.getNameRefId()) {
                return itemType;
            }
        }
        return null;
    }

    public static int getItemTypeNumber(){
        return 4;
    }
}
