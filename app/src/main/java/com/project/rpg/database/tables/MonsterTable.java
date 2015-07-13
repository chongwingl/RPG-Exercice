package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.MonsterContract;
import com.project.rpg.database.contracts.MonsterTypeContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class MonsterTable {

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MonsterContract.MonsterEntry.TABLE_NAME + " (" +
                    MonsterContract.MonsterEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    MonsterContract.MonsterEntry.COLUMN_NAME_MONSTER_TYPE_ID + INTEGER_TYPE + COMMA_SEP +
                    MonsterContract.MonsterEntry.COLUMN_NAME_LEVEL_ID + INTEGER_TYPE + COMMA_SEP +
                    MonsterContract.MonsterEntry.COLUMN_NAME_POWER_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + MonsterContract.MonsterEntry.COLUMN_NAME_MONSTER_TYPE_ID + ") " +
                    "REFERENCES " + MonsterTypeContract.MonsterTypeEntry.TABLE_NAME + "(" + MonsterTypeContract.MonsterTypeEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + MonsterContract.MonsterEntry.COLUMN_NAME_LEVEL_ID + ") " +
                    "REFERENCES " + LevelContract.LevelEntry.TABLE_NAME + "(" + LevelContract.LevelEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + MonsterContract.MonsterEntry.COLUMN_NAME_POWER_ID+ ") " +
                    "REFERENCES " + PowerContract.PowerEntry.TABLE_NAME + "(" + PowerContract.PowerEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MonsterContract.MonsterEntry.TABLE_NAME;
}
