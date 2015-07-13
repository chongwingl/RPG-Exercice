package com.project.rpg.database.tables;

import com.project.rpg.database.contracts.ItemContract;
import com.project.rpg.database.contracts.LevelContract;
import com.project.rpg.database.contracts.LootContract;
import com.project.rpg.database.contracts.MonsterContract;
import com.project.rpg.database.contracts.MonsterTypeContract;
import com.project.rpg.database.contracts.PowerContract;

/**
 * Created by laetitia on 7/8/15.
 */
public class LootTable {

    private static final String INTEGER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String END_SEP = ";";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + LootContract.LootEntry.TABLE_NAME + " (" +
                    LootContract.LootEntry._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    LootContract.LootEntry.COLUMN_NAME_MONSTER_TYPE_ID + INTEGER_TYPE + COMMA_SEP +
                    LootContract.LootEntry.COLUMN_NAME_ITEM_ID + INTEGER_TYPE + COMMA_SEP +
                    "FOREIGN KEY(" + LootContract.LootEntry.COLUMN_NAME_MONSTER_TYPE_ID + ") " +
                    "REFERENCES " + MonsterTypeContract.MonsterTypeEntry.TABLE_NAME + "(" + MonsterTypeContract.MonsterTypeEntry._ID + ")" + COMMA_SEP +
                    "FOREIGN KEY(" + LootContract.LootEntry.COLUMN_NAME_ITEM_ID + ") " +
                    "REFERENCES " + ItemContract.ItemEntry.TABLE_NAME + "(" + ItemContract.ItemEntry._ID + ")" +
                    " )" + END_SEP;

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + LootContract.LootEntry.TABLE_NAME;
}
