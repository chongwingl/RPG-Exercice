package com.project.rpg.utils;

import com.project.rpg.models.enumerations.Accuracy;
import com.project.rpg.models.enumerations.Resistance;
import com.project.rpg.models.enumerations.Strength;
import com.project.rpg.models.enumerations.Weight;

public class StatGenerator {

	public static int generateStrength(Strength weaponStrength, int characterStrength){
		int wStrength = weaponStrength.getValue();
		return Math.round(characterStrength += ((wStrength * characterStrength) / 100));
	}
	
	public static int generateAccuracy(Accuracy weaponAccuracy, int characterAccuracy){
		int wAccuracy = weaponAccuracy.getValue();
		return Math.round(characterAccuracy += ((wAccuracy + characterAccuracy) / 100));
	}
	
	public static int generateSpeed(Weight weaponWeight, int characterSpeed){
		int wWeight = weaponWeight.getValue();
		return Math.round(characterSpeed -= ((wWeight * characterSpeed) / 100));
	}
	
	public static int generateResistance(Resistance weaponResistance, int characterResistance){
		int wResistance = weaponResistance.getValue();
		return Math.round(characterResistance += ((wResistance * characterResistance) / 100));
	}

}
