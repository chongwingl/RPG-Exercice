package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemPossessedContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ItemPossessedContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ItemPossessedEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_possessed";
        public static final String COLUMN_NAME_NUMBER_OF_ITEM = "numberOfItem";
        public static final String COLUMN_NAME_ITEM_ID = "item_id";
    }
}
