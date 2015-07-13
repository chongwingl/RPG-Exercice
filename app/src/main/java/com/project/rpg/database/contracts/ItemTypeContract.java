package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemTypeContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ItemTypeContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ItemTypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_type";
        public static final String COLUMN_NAME_NAME = "name";
    }
}
