package com.project.rpg.models.monsters;

import com.project.rpg.models.powers.Critical;

public class BasicDragon extends AbstractMonster {

    private static final long serialVersionUID = 9007955513346381478L;

    public BasicDragon() {
		super("Dragon", 70, 30, 30, 30, 30);
		setPower(new Critical());
	}

    @Override
    public int getLife() {
        return 0;
    }
}
