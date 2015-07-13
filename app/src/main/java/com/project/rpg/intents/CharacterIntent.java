package com.project.rpg.intents;

import android.content.Context;
import android.content.Intent;

import com.project.rpg.models.enumerations.CharacterClass;

/**
 * Created by laetitia on 4/20/15.
 */
public class CharacterIntent extends Intent {


    public CharacterIntent(Context context, CharacterClass characterClass) {
        super();
        setClass(context, characterClass.getCharacterActivity());

    }

}
