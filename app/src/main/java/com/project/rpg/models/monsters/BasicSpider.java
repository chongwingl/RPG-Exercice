package com.project.rpg.models.monsters;

import com.project.rpg.models.powers.Poison;

public class BasicSpider extends AbstractMonster {

	public BasicSpider() {
		super("Araignée", 50, 20, 20, 20, 20);
		setPower(new Poison());
	}

}
