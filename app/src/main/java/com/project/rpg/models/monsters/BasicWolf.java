package com.project.rpg.models.monsters;

public class BasicWolf extends AbstractMonster {

    private static final long serialVersionUID = -2405508829043369819L;

    public BasicWolf() {
		super("Loup", 50, 20, 20, 20, 20);
	}

    @Override
    public int getLife() {
        return 0;
    }
}
