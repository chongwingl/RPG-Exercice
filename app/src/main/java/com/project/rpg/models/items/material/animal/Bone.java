package com.project.rpg.models.items.material.animal;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.models.items.material.AbstractMaterial;

public class Bone extends AbstractMaterial {

    private static final long serialVersionUID = 4025136346687645075L;

    public Bone(Context context) {
		super(context.getString(R.string.material_bone), Probability.LEVEL6);
        setPrice(20);
	}

}
