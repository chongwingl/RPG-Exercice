package com.project.rpg.models.items.material.natural;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Wood extends AbstractMaterial {

	public Wood(Context context) {
		super(context, R.string.material_wood, Probability.LEVEL9);
	}
}
