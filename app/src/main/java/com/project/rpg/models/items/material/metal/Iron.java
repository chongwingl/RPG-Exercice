package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Iron extends AbstractMaterial {

	public Iron(Context context) {
		super(context, R.string.material_iron, Probability.LEVEL7);
	}
}
