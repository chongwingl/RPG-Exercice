package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Steel extends AbstractMaterial {

    private static final long serialVersionUID = -6623491119710473852L;

    public Steel(Context context) {
		super(context.getString(R.string.material_steel), Probability.LEVEL5);
	}
}
