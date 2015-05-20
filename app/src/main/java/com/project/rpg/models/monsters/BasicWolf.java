package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;

public class BasicWolf extends AbstractMonster {

    private static final long serialVersionUID = -2405508829043369819L;

    public BasicWolf(Context context) {
		super(context.getString(R.string.monster_name_wolf), 50, 20, 20, 20, 20);
	}
}
