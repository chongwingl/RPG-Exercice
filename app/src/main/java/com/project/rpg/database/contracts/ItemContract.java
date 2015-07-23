package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ItemContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "item";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_PRICE = "price";
        public static final String COLUMN_NAME_ITEM_TYPE = "itemType";
        public static final String COLUMN_NAME_ITEM_SUBTYPE = "itemSubtype";
        public static final String COLUMN_NAME_SLOT = "slot";
        public static final String COLUMN_NAME_PROBABILITY_TO_FIND = "probability";
        public static final String COLUMN_NAME_POWER_ID = "power_id";
    }
}
