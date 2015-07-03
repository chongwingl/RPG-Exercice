package com.project.rpg.models.items.enhancement.healing;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;

/**
 * Created by laetitia on 4/27/15.
 */
public class SuperPotion extends AbstractPotion {

    private static final long serialVersionUID = -7697878098891049658L;

    private static final int LIFE_RESTORED = 50;
    private static final int PRICE = 80;

    public SuperPotion(Context context) {
        super(context.getString(R.string.healing_super_potion), LIFE_RESTORED);
        setPrice(PRICE);
    }

    @Override
    public Probability getProbabilityToFind() {
        return  Probability.LEVEL7;
    }
}
