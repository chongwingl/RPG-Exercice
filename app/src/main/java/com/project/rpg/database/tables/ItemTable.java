package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.ItemPossessedContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class ItemTable {

    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ", ";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + " (" +
                    ItemContract.ItemEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PRICE + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE + TEXT_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_SLOT + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + ") " +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ItemContract.ItemEntry.TABLE_NAME;

    public static final String SQL_ITEM_ITEM_POSSESSED_INNER_JOIN =
            "SELECT " +
                    ItemContract.ItemEntry._ID + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_NAME + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PRICE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE+ COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_SLOT+ COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND+ COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_POWER_ID+ COMMA_SEP +
            "FROM " + ItemContract.ItemEntry.TABLE_NAME +
            " INNER JOIN " + ItemPossessedContract.ItemPossessedEntry.TABLE_NAME + " ON "+
                    ItemContract.ItemEntry._ID + "="
                    + ItemPossessedContract.ItemPossessedEntry.TABLE_NAME + "."
                    + ItemPossessedContract.ItemPossessedEntry.COLUMN_NAME_ITEM_ID + END_SEP;

}
