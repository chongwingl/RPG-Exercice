package com.project.rpg.models.monsters;

import com.project.rpg.models.powers.Poison;

public class BasicSpider extends AbstractMonster {

    private static final long serialVersionUID = 4845746688480640845L;

    public BasicSpider() {
		super("Araignée", 50, 20, 20, 20, 20);
		setPower(new Poison());
	}

    @Override
    public int getLife() {
        return 0;
    }
}
