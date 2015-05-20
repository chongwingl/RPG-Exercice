package com.project.rpg.utils;

import java.util.Random;

public final class RandomGenerator {
	static public int getRandomInteger(int startRange, int endRange){
		Random rand = new Random();
		return rand.nextInt(endRange) + startRange;
	}
}
