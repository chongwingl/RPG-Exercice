package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class PowerTable {

    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ItemContract.ItemEntry.TABLE_NAME + " (" +
                    PowerContract.PowerEntry._ID + " INTEGER PRIMARY KEY," +
                    PowerContract.PowerEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    PowerContract.PowerEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + COMMA_SEP +
                    PowerContract.PowerEntry.COLUMN_NAME_MINIMUM_ROUND + INTEGER_TYPE + COMMA_SEP +
                    PowerContract.PowerEntry.COLUMN_NAME_MAXIMUM_ROUND + INTEGER_TYPE + COMMA_SEP +
                    PowerContract.PowerEntry.COLUMN_NAME_PERCENT_OF_EFFECT + INTEGER_TYPE + COMMA_SEP +
                    PowerContract.PowerEntry.COLUMN_NAME_PROBABILITY_TO_HAPPEN + INTEGER_TYPE +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PowerContract.PowerEntry.TABLE_NAME;
}
