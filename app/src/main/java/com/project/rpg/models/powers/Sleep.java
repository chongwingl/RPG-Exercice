package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;

public class Sleep extends AbstractPower {

    private static final long serialVersionUID = 403866814630880528L;

    public Sleep() {
		super("Sommeil", 2, 5, Probability.LEVEL3);
	}

}
