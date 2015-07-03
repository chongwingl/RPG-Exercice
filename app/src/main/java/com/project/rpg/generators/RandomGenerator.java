package com.project.rpg.generators;

import java.util.Random;

public final class RandomGenerator {
    static public int getRandomInteger(int startRange, int endRange) {
        if (endRange > startRange) {
            Random rand = new Random();
            // nextInt() returns a number between startRange (inclusive) and endRange (exclusive)
            return rand.nextInt(endRange - startRange) + startRange;
        }
        return 0;
    }
}
