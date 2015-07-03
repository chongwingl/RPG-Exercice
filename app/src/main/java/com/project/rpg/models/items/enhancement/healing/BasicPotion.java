package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class BasicPotion extends AbstractPotion {

    private static final long serialVersionUID = 436683358659644413L;

    private static final int LIFE_RESTORED = 20;
    private static final int PRICE = 40;

    public BasicPotion(Context context) {
        super(context.getString(R.string.healing_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL8;
    }
}
