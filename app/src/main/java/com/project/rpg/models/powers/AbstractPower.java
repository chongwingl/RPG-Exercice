package com.project.rpg.models.powers;

import com.project.rpg.models.enumerations.Probability;
import com.project.rpg.utils.RandomGenerator;

import java.io.Serializable;

public abstract class AbstractPower implements Serializable{

    private static final long serialVersionUID = 6270650943827781204L;
    private String name;
	private int startRange;
	private int endRange;
	private Probability probabilityToHappen;
	
	public AbstractPower(String name, int startRange, int endRange, Probability probabilityToHappen) {
		this.name = name;
		this.startRange = startRange;
		this.endRange = endRange;
		this.probabilityToHappen = probabilityToHappen;
	}

	public String getName() {
		return name;
	}
	
	public int roundLasting(){
		return RandomGenerator.getRandomInteger(startRange, endRange);
	}
	
	public boolean hasEffect(){
		int randomNumber = RandomGenerator.getRandomInteger(0, 100);
		if(randomNumber <= probabilityToHappen.getValue()){
			return true;
		}
		return false;
	}
}
