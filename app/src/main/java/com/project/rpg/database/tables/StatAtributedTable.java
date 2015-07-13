package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.CharacterContract;
import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.MonsterContract;
import com.project.rpg.database.contracts.MonsterTypeContract;
import com.project.rpg.database.contracts.PowerContract;
import com.project.rpg.database.contracts.StatAttributedContract;
import com.project.rpg.database.contracts.StatContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class StatAtributedTable {

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + StatAttributedContract.StatAttributedEntry.TABLE_NAME + " (" +
                    StatAttributedContract.StatAttributedEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    StatAttributedContract.StatAttributedEntry.COLUMN_NAME_VALUE + INTEGER_TYPE + COMMA_SEP +
                    StatAttributedContract.StatAttributedEntry.COLUMN_NAME_MONSTER_ID + INTEGER_TYPE + COMMA_SEP +
                    StatAttributedContract.StatAttributedEntry.COLUMN_NAME_CHARACTER_ID + INTEGER_TYPE + COMMA_SEP +
                    StatAttributedContract.StatAttributedEntry.COLUMN_NAME_ITEM_ID + INTEGER_TYPE + COMMA_SEP +
                    StatAttributedContract.StatAttributedEntry.COLUMN_NAME_STAT_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + StatAttributedContract.StatAttributedEntry.COLUMN_NAME_MONSTER_ID + ") " +
                    "REFERENCES " + MonsterContract.MonsterEntry.TABLE_NAME + "(" + MonsterContract.MonsterEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + StatAttributedContract.StatAttributedEntry.COLUMN_NAME_CHARACTER_ID + ") " +
                    "REFERENCES " + CharacterContract.CharacterEntry.TABLE_NAME + "(" + CharacterContract.CharacterEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + StatAttributedContract.StatAttributedEntry.COLUMN_NAME_ITEM_ID+ ") " +
                    "REFERENCES " + ItemContract.ItemEntry.TABLE_NAME + "(" + ItemContract.ItemEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + StatAttributedContract.StatAttributedEntry.COLUMN_NAME_STAT_ID + ") " +
                    "REFERENCES " + StatContract.StatEntry.TABLE_NAME + "(" + StatContract.StatEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + StatAttributedContract.StatAttributedEntry.TABLE_NAME;
}
