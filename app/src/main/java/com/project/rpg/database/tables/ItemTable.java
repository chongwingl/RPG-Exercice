package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.ItemSubtypeContract;
import com.project.rpg.database.contracts.ItemTypeContract;
import com.project.rpg.database.contracts.PowerContract;
import com.project.rpg.database.contracts.ProbabilityContract;
import com.project.rpg.database.contracts.SlotContract;

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
                    ItemContract.ItemEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE_ID + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE_ID + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PRICE + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_SLOT_ID + INTEGER_TYPE + COMMA_SEP +
                    ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_POWER_ID + ") " +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_PROBABILITY_TO_FIND_ID + ") " +
                    "REFERENCES " + ProbabilityContract.ProbabilityEntry.TABLE_NAME + "(" + ProbabilityContract.ProbabilityEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_SLOT_ID + ") " +
                    "REFERENCES " + SlotContract.SlotEntry.TABLE_NAME + "(" + SlotContract.SlotEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_ITEM_TYPE_ID + ") " +
                    "REFERENCES " + ItemTypeContract.ItemTypeEntry.TABLE_NAME + "(" + ItemTypeContract.ItemTypeEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + ItemContract.ItemEntry.COLUMN_NAME_ITEM_SUBTYPE_ID + ") " +
                    "REFERENCES " + ItemSubtypeContract.ItemSubtypeEntry.TABLE_NAME + "(" + ItemSubtypeContract.ItemSubtypeEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ItemContract.ItemEntry.TABLE_NAME;
}
