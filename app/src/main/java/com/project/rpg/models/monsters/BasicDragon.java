package com.project.rpg.models.monsters;

import com.project.rpg.models.powers.Critical;

public class BasicDragon extends AbstractMonster {

	public BasicDragon() {
		super("Dragon", 70, 30, 30, 30, 30);
		setPower(new Critical());
	}

}
