package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class HyperPotion extends AbstractPotion {

    private static final long serialVersionUID = 7050384679066582590L;

    private static final int LIFE_RESTORED = 100;
    private static final int PRICE = 100;

    public HyperPotion(Context context) {
        super(context.getString(R.string.healing_hyper_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL5;
    }
}
