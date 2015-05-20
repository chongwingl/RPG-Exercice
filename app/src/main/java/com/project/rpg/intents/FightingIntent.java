package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.FightingActivity;
import com.project.rpg.models.monsters.AbstractMonster;

/**
 * Created by laetitia on 5/14/15.
 */
public class FightingIntent extends Intent {

    private static final String ARG_MONSTER = "ARG_MONSTER";

    public FightingIntent(Context context, AbstractMonster monster) {
        super(context, FightingActivity.class);
        putExtra(ARG_MONSTER, monster);
    }

    public FightingIntent(Intent intent) {
        super(intent);
    }

    public AbstractMonster getMonster(){
        return (AbstractMonster) getSerializableExtra(ARG_MONSTER);
    }
}
