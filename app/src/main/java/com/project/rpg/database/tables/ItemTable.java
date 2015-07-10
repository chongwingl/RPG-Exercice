package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemTable {

    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + " (" +
                    ItemContract.ItemEntry._ID + " INTEGER PRIMARY KEY," +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PRICE + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_WEIGHT + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_STRENGTH + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ACCURACY + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_RESISTANCE + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PART_OF_BODY + TEXT_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_LIFE_POINTS + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND + INTEGER_TYPE +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + ") " +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ItemContract.ItemEntry.TABLE_NAME;
}
