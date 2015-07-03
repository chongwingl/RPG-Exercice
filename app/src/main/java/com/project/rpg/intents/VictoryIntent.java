package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.VictoryActivity;
import com.project.rpg.models.enumerations.MonsterLevel;

/**
 * Created by laetitia on 5/14/15.
 */
public class VictoryIntent extends Intent {

    private static final String ARG_MONSTER_LEVEL = "ARG_MONSTER_LEVEL";
    private static final String ARG_MONSTER_STRENGTH = "ARG_MONSTER_STRENGTH";

    public VictoryIntent(Context context, MonsterLevel level, int monsterStrength) {
        super(context, VictoryActivity.class);
        putExtra(ARG_MONSTER_LEVEL, level);
        putExtra(ARG_MONSTER_STRENGTH, monsterStrength);
    }

    public VictoryIntent(Intent intent) {
        super(intent);
    }

    public MonsterLevel getMonsterLevel() {
        MonsterLevel level =  (MonsterLevel) getSerializableExtra(ARG_MONSTER_LEVEL);
        return level;
    }

    public int getMonsterStrength() {
        return getIntExtra(ARG_MONSTER_STRENGTH, 0);
    }

}
