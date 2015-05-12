package com.project.rpg.models.items.healing;

import com.project.rpg.models.enumerations.items.ItemType;
import com.project.rpg.models.items.AbstractItem;

/**
 * Created by laetitia on 4/27/15.
 */
public abstract class AbstractHealing extends AbstractItem {

    private static final long serialVersionUID = -373216204069937455L;

    protected AbstractHealing(String name) {
        super(name);
    }

    // TODO the healing power!!

    @Override
    protected void setItemType() {
        mItemType = ItemType.HEALING;
    }
}
