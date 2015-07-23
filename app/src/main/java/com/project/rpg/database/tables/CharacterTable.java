package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.CharacterContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class CharacterTable {

    private static final String TEXT_NOT_NULL_TYPE = " TEXT NOT NULL";
    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CharacterContract.CharacterEntry.TABLE_NAME + " (" +
                    CharacterContract.CharacterEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_NAME + TEXT_NOT_NULL_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_GOLD + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_LIFE + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_MAX_LIFE + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_LEVEL_ID + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_AFFECTED_BY_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + CharacterContract.CharacterEntry.COLUMN_NAME_AFFECTED_BY_POWER_ID + ") " +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PowerContract.PowerEntry.TABLE_NAME;
}
