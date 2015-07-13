package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.activities.CharacterCreationActivity;
import com.project.rpg.models.enumerations.CharacterClass;

/**
 * Created by laetitia on 4/20/15.
 */
public class CharacterCreationIntent extends Intent {


    public CharacterCreationIntent(Context context) {
        super();
        setClass(context, CharacterCreationActivity.class);

    }

}
