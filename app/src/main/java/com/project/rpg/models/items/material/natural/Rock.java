package com.project.rpg.models.items.material.natural;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Rock extends AbstractMaterial {

    private static final long serialVersionUID = -3802825210312700299L;

    public Rock(Context context) {
		super(context.getString(R.string.material_rock), Probability.LEVEL9);
        setPrice(5);
	}
}
