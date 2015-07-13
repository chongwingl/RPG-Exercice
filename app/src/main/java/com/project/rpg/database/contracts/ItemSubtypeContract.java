package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemSubtypeContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ItemSubtypeContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ItemSubtypeEntry implements BaseColumns {
        public static final String TABLE_NAME = "item_subtype";
        public static final String COLUMN_NAME_NAME = "name";
    }
}
