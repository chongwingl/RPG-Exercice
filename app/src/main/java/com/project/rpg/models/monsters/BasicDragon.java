package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.powers.Critical;

public class BasicDragon extends AbstractMonster {

    private static final long serialVersionUID = 9007955513346381478L;

    public BasicDragon(Context context) {
		super(context.getString(R.string.monster_name_dragon), 70, 30, 30, 30, 30);
		setPower(new Critical());
	}
}
