package com.project.rpg.models.items.healing.potion;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.items.healing.AbstractHealing;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicPotion extends AbstractHealing {

    public BasicPotion(Context context) {
        super(context, R.string.healing_potion);
    }

}
