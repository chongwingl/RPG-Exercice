package com.project.rpg.models.items.material.metal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Mithril extends AbstractMaterial {

    private static final long serialVersionUID = 5155097410806964666L;

    public Mithril(Context context) {
		super(context.getString(R.string.material_mithril), Probability.LEVEL0);
        setPrice(50);
	}
}
