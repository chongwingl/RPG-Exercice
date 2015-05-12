package com.project.rpg.models.items.material.natural;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Wood extends AbstractMaterial {

    private static final long serialVersionUID = -2889583806263147888L;

    public Wood(Context context) {
		super(context.getString(R.string.material_wood), Probability.LEVEL9);
	}
}
