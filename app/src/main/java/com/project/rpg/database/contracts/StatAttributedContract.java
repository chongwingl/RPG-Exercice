package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class StatAttributedContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public StatAttributedContract() {}

    /* Inner class that defines the table contents */
    public static abstract class StatAttributedEntry implements BaseColumns {
        public static final String TABLE_NAME = "stat_attributed";
        public static final String COLUMN_NAME_VALUE = "value";
        public static final String COLUMN_NAME_MONSTER_ID = "monster_id";
        public static final String COLUMN_NAME_CHARACTER_ID = "character_id";
        public static final String COLUMN_NAME_ITEM_ID = "item_id";
        public static final String COLUMN_NAME_STAT_ID = "stat_id";
    }
}
