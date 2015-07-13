package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemPossessedContract;
import com.project.rpg.database.contracts.CharacterContract;
import com.project.rpg.database.contracts.EquippedContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class EquippedTable {

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + EquippedContract.EquippedEntry.TABLE_NAME + " (" +
                    EquippedContract.EquippedEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    EquippedContract.EquippedEntry.COLUMN_NAME_CHARACTER_ID + INTEGER_TYPE + COMMA_SEP +
                    EquippedContract.EquippedEntry.COLUMN_NAME_BAG_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + EquippedContract.EquippedEntry.COLUMN_NAME_CHARACTER_ID+ ") " +
                    "REFERENCES " + CharacterContract.CharacterEntry.TABLE_NAME + "(" + CharacterContract.CharacterEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + EquippedContract.EquippedEntry.COLUMN_NAME_BAG_ID+ ") " +
                    "REFERENCES " + ItemPossessedContract.ItemPossessedEntry.TABLE_NAME + "(" + ItemPossessedContract.ItemPossessedEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + EquippedContract.EquippedEntry.TABLE_NAME;
}
