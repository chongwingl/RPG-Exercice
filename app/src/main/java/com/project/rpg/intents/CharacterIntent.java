package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.CharacterCreationActivity;
import com.project.rpg.activities.FighterActivity;

/**
 * Created by laetitia on 4/20/15.
 */
public class CharacterIntent extends Intent {


    public CharacterIntent(Context context) {
        super();
        setClass(context, FighterActivity.class);

    }

}
