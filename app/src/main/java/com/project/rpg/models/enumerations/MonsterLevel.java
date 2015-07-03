package com.project.rpg.models.enumerations;

/**
 * Created by laetitia on 6/30/15.
 */
public enum MonsterLevel {
    WEAK(10),
    NORMAL(30),
    STRONG(50);

    private final int mLevel;

    MonsterLevel(int level) {
        mLevel = level;
    }

    public int getLevel() {
        return mLevel;
    }
}
