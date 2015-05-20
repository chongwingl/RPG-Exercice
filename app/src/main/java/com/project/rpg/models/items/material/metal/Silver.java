package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Silver extends AbstractMaterial {

    private static final long serialVersionUID = -3100424949660753382L;

    public Silver(Context context) {
		super(context.getString(R.string.material_silver), Probability.LEVEL3);
        setPrice(30);
	}

}
