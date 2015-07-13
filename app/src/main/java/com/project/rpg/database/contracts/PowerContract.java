package com.project.rpg.database.contracts;

import android.provider.BaseColumns;

/**
 * Created by laetitia on 7/8/15.
 */
public class PowerContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public PowerContract() {}

    /* Inner class that defines the table contents */
    public static abstract class PowerEntry implements BaseColumns {
        public static final String TABLE_NAME = "power";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_DESCRIPTION = "description";
        public static final String COLUMN_NAME_MINIMUM_ROUND = "minimumRound";
        public static final String COLUMN_NAME_MAXIMUM_ROUND = "maximumRound";
        public static final String COLUMN_NAME_PERCENT_OF_EFFECT = "percentOfEffect";
        public static final String COLUMN_NAME_PROBABILITY_TO_HAPPEN_ID = "probability_id";
        public static final String COLUMN_NAME_STAT_ID = "stat_id";
        public static final String COLUMN_NAME_EFFECT_ID = "effect_id";
    }
}
