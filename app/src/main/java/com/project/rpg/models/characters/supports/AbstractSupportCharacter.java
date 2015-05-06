package com.project.rpg.models.characters.supports;

import com.project.rpg.models.characters.AbstractCharacter;
import com.project.rpg.models.stores.AbstractStoreBuilder;

public abstract class AbstractSupportCharacter extends AbstractCharacter {

	private final static int BAG_SIZE_MAX = 50;
	private AbstractStoreBuilder store;

	public AbstractSupportCharacter(String name) {
		super(name);
	}
}
