package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.powers.Critical;

public class BasicDragon extends AbstractMonster {

    private static final long serialVersionUID = 9007955513346381478L;

	private static final int LIFE = 70;
	private static final int STRENGTH = 30;
	private static final int SPEED = 30;
	private static final int ACCURACY = 70;
	private static final int RESISTANCE = 30;

    public BasicDragon(Context context) {
		super(context.getString(R.string.dragon), LIFE, STRENGTH, SPEED, ACCURACY, RESISTANCE);
		setPower(new Critical());
	}
}
