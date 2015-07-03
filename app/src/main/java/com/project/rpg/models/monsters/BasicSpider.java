package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.powers.Poison;

public class BasicSpider extends AbstractMonster {

    private static final long serialVersionUID = 4845746688480640845L;

	private static final int LIFE = 50;
	private static final int STRENGTH = 20;
	private static final int SPEED = 20;
	private static final int ACCURACY = 20;
	private static final int RESISTANCE = 20;

    public BasicSpider(Context context) {
		super(context.getString(R.string.spider), LIFE, STRENGTH, SPEED, ACCURACY, RESISTANCE);
		setPower(new Poison());
	}
}
