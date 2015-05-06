package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Copper extends AbstractMaterial {

	public Copper(Context context) {
		super(context, R.string.material_copper, Probability.LEVEL8);
	}


}
