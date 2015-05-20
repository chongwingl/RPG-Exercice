package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Iron extends AbstractMaterial {

    private static final long serialVersionUID = -7053228029704737367L;

    public Iron(Context context) {
		super(context.getString(R.string.material_iron), Probability.LEVEL7);
        setPrice(20);
	}
}
