package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Copper extends AbstractMaterial {

    private static final long serialVersionUID = -5147724696662066552L;

    public Copper(Context context) {
		super(context.getString(R.string.material_copper), Probability.LEVEL8);
        setPrice(10);
	}


}
