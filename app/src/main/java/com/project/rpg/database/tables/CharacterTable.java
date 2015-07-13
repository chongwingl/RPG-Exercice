package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.CharacterContract;
import com.project.rpg.database.contracts.ClassContract;
import com.project.rpg.database.contracts.EffectContract;
import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.PowerContract;
import com.project.rpg.database.contracts.ProbabilityContract;
import com.project.rpg.database.contracts.StatContract;

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
                    CharacterContract.CharacterEntry.COLUMN_NAME_CLASS_ID + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_LEVEL_ID + INTEGER_TYPE + COMMA_SEP +
                    CharacterContract.CharacterEntry.COLUMN_NAME_AFFECTED_BY_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + CharacterContract.CharacterEntry.COLUMN_NAME_AFFECTED_BY_POWER_ID + ") " + COMMA_SEP +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + CharacterContract.CharacterEntry.COLUMN_NAME_LEVEL_ID + ") " +
                    "REFERENCES " + LevelContract.LevelEntry.TABLE_NAME + "(" + LevelContract.LevelEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + CharacterContract.CharacterEntry.COLUMN_NAME_CLASS_ID + ") " +
                    "REFERENCES " + ClassContract.ClassEntry.TABLE_NAME + "(" + ClassContract.ClassEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + PowerContract.PowerEntry.TABLE_NAME;
}
