package com.project.rpg.models.items.material.animal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Skin extends AbstractMaterial {

	public Skin(Context context) {
		super(context, R.string.material_skin, Probability.LEVEL9);
	}


}
