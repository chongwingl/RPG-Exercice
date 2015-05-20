package com.project.rpg.models.items.material.animal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Skin extends AbstractMaterial {

    private static final long serialVersionUID = 2393071689305455950L;

    public Skin(Context context) {
		super(context.getString(R.string.material_skin), Probability.LEVEL9);
        setPrice(20);
	}


}
