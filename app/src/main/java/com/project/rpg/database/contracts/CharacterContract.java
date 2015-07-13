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
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_GOLD = "gold";
        public static final String COLUMN_NAME_CLASS_ID = "class_id";
        public static final String COLUMN_NAME_LEVEL_ID = "level_id";
        public static final String COLUMN_NAME_AFFECTED_BY_POWER_ID = "power_id";
    }
}
