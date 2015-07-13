package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemPossessedContract;
import com.project.rpg.database.contracts.ItemContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemPossessedTable {

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ItemPossessedContract.ItemPossessedEntry.TABLE_NAME + " (" +
                    ItemPossessedContract.ItemPossessedEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_NUMBER_OF_ITEM + INTEGER_TYPE + COMMA_SEP +
                    ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_ITEM_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_ITEM_ID + ") " +
                    "REFERENCES " + ItemContract.ItemEntry.TABLE_NAME + "(" + ItemContract.ItemEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ItemPossessedContract.ItemPossessedEntry.TABLE_NAME;
}
