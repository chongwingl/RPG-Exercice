package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class EquippedContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public EquippedContract() {}

    /* Inner class that defines the table contents */
    public static abstract class EquippedEntry implements BaseColumns {
        public static final String TABLE_NAME = "equipped";
        public static final String COLUMN_NAME_CHARACTER_ID = "character_id";
        public static final String COLUMN_NAME_BAG_ID = "bag_id";
    }
}
