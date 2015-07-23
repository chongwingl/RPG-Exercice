package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class MonsterContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public MonsterContract() {}

    /* Inner class that defines the table contents */
    public static abstract class MonsterEntry implements BaseColumns {
        public static final String TABLE_NAME = "monster";
        public static final String COLUMN_NAME_LIFE = "life";
        public static final String COLUMN_NAME_MAX_LIFE = "maxLife";
        public static final String COLUMN_NAME_MONSTER_TYPE_ID = "monster_type_id";
        public static final String COLUMN_NAME_LEVEL_ID = "level_id";
        public static final String COLUMN_NAME_POWER_ID = "power_id";
    }
}
