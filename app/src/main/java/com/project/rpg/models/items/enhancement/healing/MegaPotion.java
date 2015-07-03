package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class MegaPotion extends AbstractPotion {

    private static final long serialVersionUID = -2626098899356350838L;

    private static final int LIFE_RESTORED = 200;
    private static final int PRICE = 150;

    public MegaPotion(Context context) {
        super(context.getString(R.string.healing_mega_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL3;
    }
}
