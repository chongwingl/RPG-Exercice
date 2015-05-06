package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Steel extends AbstractMaterial {

	public Steel(Context context) {
		super(context, R.string.material_steel, Probability.LEVEL5);
	}
}
