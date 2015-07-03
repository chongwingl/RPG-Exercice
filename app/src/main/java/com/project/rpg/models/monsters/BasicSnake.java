package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;

public class BasicSnake extends AbstractMonster {

    private static final long serialVersionUID = -2405508829043369819L;

    private static final int LIFE = 50;
    private static final int STRENGTH = 20;
    private static final int SPEED = 20;
    private static final int ACCURACY = 20;
    private static final int RESISTANCE = 20;

    public BasicSnake(Context context) {
		super(context.getString(R.string.snake), LIFE, STRENGTH, SPEED, ACCURACY, RESISTANCE);
	}
}
