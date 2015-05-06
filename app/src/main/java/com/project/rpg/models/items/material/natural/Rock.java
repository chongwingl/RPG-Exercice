package com.project.rpg.models.items.material.natural;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Rock extends AbstractMaterial {

	public Rock(Context context) {
		super(context, R.string.material_rock, Probability.LEVEL9);
	}
}
