package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Gold extends AbstractMaterial {

    private static final long serialVersionUID = -3243519724550333649L;

    public Gold(Context context) {
		super(context.getString(R.string.material_gold), Probability.LEVEL2);
	}
}
