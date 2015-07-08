package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class CharacterContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public CharacterContract() {}

    /* Inner class that defines the table contents */
    public static abstract class CharacterEntry implements BaseColumns {
        public static final String TABLE_NAME = "character";
        public static final String COLUMN_NAME_CHARACTER_TYPE = "characterType";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_GOLD = "gold";
        public static final String COLUMN_NAME_WEIGHT = "weight";
        public static final String COLUMN_NAME_STRENGTH = "strength";
        public static final String COLUMN_NAME_ACCURACY = "accuracy";
        public static final String COLUMN_NAME_RESISTANCE = "resistance";
        public static final String COLUMN_NAME_PROBABILITY_TO_FIND = "probabilityToFind";
    }
}
