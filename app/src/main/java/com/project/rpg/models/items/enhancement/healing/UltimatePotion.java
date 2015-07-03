package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class UltimatePotion extends AbstractPotion {

    private static final long serialVersionUID = -2461129306303304111L;

    private static final int LIFE_RESTORED = 500;
    private static final int PRICE = 500;

    public UltimatePotion(Context context) {
        super(context.getString(R.string.healing_ultimate_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL1;
    }
}
