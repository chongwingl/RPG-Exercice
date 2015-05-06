package com.project.rpg.models.enumerations.items;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.items.material.animal.Bone;
import com.project.rpg.models.items.material.animal.Skin;
import com.project.rpg.models.items.material.metal.Copper;
import com.project.rpg.models.items.material.metal.Gold;
import com.project.rpg.models.items.material.metal.Iron;
import com.project.rpg.models.items.material.metal.Mithril;
import com.project.rpg.models.items.material.metal.Silver;
import com.project.rpg.models.items.material.metal.Steel;
import com.project.rpg.models.items.material.natural.Rock;
import com.project.rpg.models.items.material.natural.Wood;

/**
 * Created by laetitia on 4/27/15.
 */
public enum MaterialItem {

    // animal;
    BONE(R.string.material_bone, Bone.class),
    SKIN(R.string.material_skin, Skin.class),
    // metal
    COPPER(R.string.material_copper, Copper.class),
    GOLD(R.string.material_gold, Gold.class),
    IRON(R.string.material_iron, Iron.class),
    MITHRIL(R.string.material_mithril, Mithril.class),
    SILVER(R.string.material_silver, Silver.class),
    STEEL(R.string.material_steel, Steel.class),
    // material
    ROCK(R.string.material_rock, Rock.class),
    WOOD(R.string.material_wood, Wood.class);

    private int mNameRefId;
    private Class mClazz;

    MaterialItem(int nameRefId, Class clazz) {
        mNameRefId = nameRefId;
        mClazz = clazz;
    }

    public int getNameRefId() {
        return mNameRefId;
    }

    public Class getClazz() {
        return mClazz;
    }

    public static MaterialItem getItemByName(Context context, String name) {
        for (MaterialItem materialItem : values()) {
            if (name.equals(context.getString(materialItem.getNameRefId()))) {
                return materialItem;
            }
        }
        return null;
    }
}
