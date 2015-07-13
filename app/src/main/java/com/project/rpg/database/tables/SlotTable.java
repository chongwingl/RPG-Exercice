package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.SlotContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class SlotTable {

    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + SlotContract.SlotEntry.TABLE_NAME + " (" +
                    SlotContract.SlotEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    SlotContract.SlotEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + SlotContract.SlotEntry.TABLE_NAME;
}
