package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class LootContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public LootContract() {}

    /* Inner class that defines the table contents */
    public static abstract class LootEntry implements BaseColumns {
        public static final String TABLE_NAME = "loot";
        public static final String COLUMN_NAME_MONSTER_TYPE_ID = "monster_type_id";
        public static final String COLUMN_NAME_ITEM_ID = "item_id";
    }
}
